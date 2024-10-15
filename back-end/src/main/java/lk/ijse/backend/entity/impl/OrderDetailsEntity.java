package lk.ijse.backend.entity.impl;

import jakarta.persistence.*;
import lk.ijse.backend.embedded.OrderDetailPrimaryKey;
import lk.ijse.backend.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orderDetail")
public class OrderDetailsEntity implements SuperEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId", referencedColumnName = "orderId", insertable=false, updatable=false)
    private OrderEntity order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itemId", referencedColumnName = "itemId", insertable=false, updatable=false)
    private ItemEntity item;

    private int quantity;
    private double price;
    @EmbeddedId
    private OrderDetailPrimaryKey orderDetailPrimaryKey;
}
