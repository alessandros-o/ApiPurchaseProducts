package br.com.iteris.universidade.segundaapi.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "OrderItem")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "UnitPrice", columnDefinition = "decimal(12, 2)")
    private double unitPrice;
    @Column(name = "Quantity")
    private Integer quantity;
    @Column(name = "OrderId", insertable = false, updatable = false)
    private Long orderId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderId")
    private Order order;
    @Column(name = "ProductId", insertable = false, updatable = false)
    private Long productId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductId")
    private Product product;
}
