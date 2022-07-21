package br.com.iteris.universidade.segundaapi.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "`Order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "OrderDate", columnDefinition = "datetime")
    private LocalDateTime orderDate;
    @Column(name = "OrderNumber", length = 10)
    private String orderNumber;
    @Column(name = "TotalAmount", columnDefinition = "decimal(12, 2)")
    private double totalAmount;
    @Column(name = "CustomerId", insertable = false, updatable = false)
    private Long customerId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerId")
    private Customer customer;
    @OneToMany(mappedBy = "orderId", fetch = FetchType.LAZY)
    private List<OrderItem> orderItems;


}
