package lk.ijse.backend.entity.impl;

import jakarta.persistence.*;
import lk.ijse.backend.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class OrderEntity implements SuperEntity {
    @Id
    private String orderId;
    private String date;
    private double total;
    private String discount;
    private double subtotal;
    private double cash;
    private double balance;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "custId", nullable = false)
    private CustomerEntity customer;
    @OneToMany(mappedBy = "order")
    private List<OrderDetailsEntity> orderDetailsEntityList = new ArrayList<>();
}
