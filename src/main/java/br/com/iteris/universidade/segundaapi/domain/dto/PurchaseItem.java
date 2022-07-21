package br.com.iteris.universidade.segundaapi.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class PurchaseItem {
    @NotEmpty
    private Long productId;
    @NotEmpty
    private Double discount;
    @NotEmpty
    private Integer quantity;
}
