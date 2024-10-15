package lk.ijse.backend.service.impl;

import lk.ijse.backend.dao.ItemDao;
import lk.ijse.backend.dao.OrderDao;
import lk.ijse.backend.dao.OrderDetailDao;
import lk.ijse.backend.dto.impl.ItemDTO;
import lk.ijse.backend.dto.impl.OrderDTO;
import lk.ijse.backend.dto.impl.OrderDetailDTO;
import lk.ijse.backend.embedded.OrderDetailPrimaryKey;
import lk.ijse.backend.entity.impl.ItemEntity;
import lk.ijse.backend.entity.impl.OrderDetailsEntity;
import lk.ijse.backend.entity.impl.OrderEntity;
import lk.ijse.backend.exception.DataPersistFailedException;
import lk.ijse.backend.service.OrderService;
import lk.ijse.backend.util.AppUtil;
import lk.ijse.backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderDetailDao orderDetailDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveOrder(OrderDTO orderDTO) {
        orderDTO.setOrderId(AppUtil.createOrderId());
        OrderEntity orderEntity = mapping.convertToOrderEntity(orderDTO);
        OrderEntity savedOrderEntity = orderDao.save(orderEntity);
        if (savedOrderEntity == null && savedOrderEntity.getOrderId() == null) {
            throw new DataPersistFailedException("cannot save order");
        }else {
            for (ItemDTO itemDTO : orderDTO.getItemDTOList()){
                Optional<ItemEntity> item = itemDao.findById(itemDTO.getItemId());

                OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
                orderDetailDTO.setOrderId(orderDTO.getOrderId());
                orderDetailDTO.setQuantity(itemDTO.getQuantity());
                orderDetailDTO.setPrice(itemDTO.getPrice());
                orderDetailDTO.setItemId(itemDTO.getItemId());

                OrderDetailPrimaryKey orderDetailPrimaryKey = new OrderDetailPrimaryKey(orderDTO.getOrderId(), itemDTO.getItemId());
                OrderDetailsEntity orderDetailsEntity = mapping.convertToOrderDetailEntity(orderDetailDTO);
                orderDetailsEntity.setOrderDetailPrimaryKey(orderDetailPrimaryKey);

                OrderDetailsEntity saveOrderDetail = orderDetailDao.save(orderDetailsEntity);
                if (saveOrderDetail == null && saveOrderDetail.getOrder().getOrderId() == null) {
                    throw new DataPersistFailedException("cannot save order detail");
                }else {
                    ItemEntity itemEntity = mapping.convertToItemEntity(itemDTO);
                    itemEntity.setQuantity((item.get().getQuantity()) - itemDTO.getQuantity());
                    itemDao.save(itemEntity);
                }
            }
        }
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<OrderDTO> orderDTOList = mapping.convertToOrderDTO(orderDao.findAll());
        return orderDTOList;
    }
}
