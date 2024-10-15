package lk.ijse.backend.service;

import lk.ijse.backend.dto.impl.OrderDTO;

import java.util.List;

public interface OrderService {
    void saveOrder(OrderDTO order);
    List<OrderDTO> getAllOrders();
}
