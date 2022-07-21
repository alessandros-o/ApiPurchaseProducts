package br.com.iteris.universidade.segundaapi.controller;

import br.com.iteris.universidade.segundaapi.domain.dto.PaginatedSearchRequest;
import br.com.iteris.universidade.segundaapi.domain.dto.ProductResponse;
import br.com.iteris.universidade.segundaapi.domain.dto.ResponseBase;
import br.com.iteris.universidade.segundaapi.domain.dto.SearchProductsRequest;
import br.com.iteris.universidade.segundaapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductsController {

    private final ProductService productService;

    @GetMapping("api/products")
    public ResponseEntity pesquisar(SearchProductsRequest searchRequest){
        ResponseBase<Page<ProductResponse>> retorno = productService.pesquisar(searchRequest);
        return ResponseEntity.ok(retorno);
    }
}
