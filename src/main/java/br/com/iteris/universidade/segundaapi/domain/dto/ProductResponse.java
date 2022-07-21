package br.com.iteris.universidade.segundaapi.domain.dto;

import br.com.iteris.universidade.segundaapi.domain.entity.Product;
import lombok.Data;

@Data
public class ProductResponse {
    private long Id;
    private String ProductName;
    private Double UnitPrice;
    private boolean isDiscontinued;

    public ProductResponse(Product product) {
        this.Id = product.getId();
        this.ProductName = product.getProductName();
        this.UnitPrice = product.getUnitPrice();
        this.isDiscontinued = product.getIsDiscontinued();
    }
}
