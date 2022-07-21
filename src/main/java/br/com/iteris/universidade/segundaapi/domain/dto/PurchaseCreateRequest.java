package br.com.iteris.universidade.segundaapi.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class PurchaseCreateRequest {
    @NotNull
    private Long customerId;
    @NotEmpty
    private List<PurchaseItem> itens;
}
