package br.com.iteris.universidade.segundaapi.service;

import br.com.iteris.universidade.segundaapi.domain.dto.PaginatedSearchRequest;
import br.com.iteris.universidade.segundaapi.domain.dto.ProductResponse;
import br.com.iteris.universidade.segundaapi.domain.dto.ResponseBase;
import br.com.iteris.universidade.segundaapi.domain.dto.SearchProductsRequest;
import br.com.iteris.universidade.segundaapi.domain.entity.Product;
import br.com.iteris.universidade.segundaapi.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductsRepository productsRepository;

    public ResponseBase<Page<ProductResponse>> pesquisar(SearchProductsRequest searchRequest){

        if (searchRequest.getPaginaAtual() < 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O indice da página atual deve começar em 0");
        }

        if (searchRequest.getQtdPorPagina() < 1 || searchRequest.getQtdPorPagina() > 50){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quantidade de itens por página deve ser entre 1 e 50 itens");
        }

        PageRequest pageRequest = PageRequest.of(searchRequest.getPaginaAtual(), searchRequest.getQtdPorPagina());

        //Page<Product> productPage = productsRepository.findAll(pageRequest);
        //Page<Product> productPageDiscontinuedTrue = productsRepository.findByIsDiscontinued(true, pageRequest);
        //Page<Product> productPageDiscontinuedFalse = productsRepository.findByIsDiscontinued(false, pageRequest);

        Page<Product> productResponsePage;
        Boolean isDiscontinued = searchRequest.getIsDiscontinued();
        if (isDiscontinued != null) {
            productResponsePage = productsRepository.findByIsDiscontinued(isDiscontinued, pageRequest);
        }else {
            productResponsePage = productsRepository.findAll(pageRequest);
        }
        return new ResponseBase<>(productResponsePage.map(ProductResponse::new));
    }
}
