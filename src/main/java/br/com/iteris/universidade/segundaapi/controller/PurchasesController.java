package br.com.iteris.universidade.segundaapi.controller;

import br.com.iteris.universidade.segundaapi.domain.dto.PurchaseCreateRequest;
import br.com.iteris.universidade.segundaapi.domain.dto.PurchaseResponse;
import br.com.iteris.universidade.segundaapi.domain.dto.ResponseBase;
import br.com.iteris.universidade.segundaapi.domain.dto.SearchOrdersRequest;
import br.com.iteris.universidade.segundaapi.service.PurchasesService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class PurchasesController {

    private final PurchasesService purchasesService;

    @PostMapping("api/purchases")
    public ResponseEntity post(@Valid @RequestBody PurchaseCreateRequest postModel){
        ResponseBase<PurchaseResponse> retorno = purchasesService.cadastrar(postModel);
        return ResponseEntity.ok(retorno);
    }

    @GetMapping("api/purchase")
    public ResponseEntity pesquisar(SearchOrdersRequest searchOrdersRequest){
        ResponseBase<Page<PurchaseResponse>> retorno = purchasesService.pesquisar(searchOrdersRequest);
        return ResponseEntity.ok(retorno);
    }
}
