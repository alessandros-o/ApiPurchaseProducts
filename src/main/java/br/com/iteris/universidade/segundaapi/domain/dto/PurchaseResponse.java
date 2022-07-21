package br.com.iteris.universidade.segundaapi.domain.dto;

import br.com.iteris.universidade.segundaapi.domain.entity.Order;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PurchaseResponse {
    private Long id;
    private LocalDateTime orderDate;
    private double totalAmount;

    public PurchaseResponse(Order novaOrder){
        this.id = novaOrder.getId();
        this.orderDate = novaOrder.getOrderDate();
        this.totalAmount = novaOrder.getTotalAmount();
    }
}
