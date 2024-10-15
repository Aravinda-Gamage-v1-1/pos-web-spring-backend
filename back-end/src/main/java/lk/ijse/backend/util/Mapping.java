package lk.ijse.backend.util;

import lk.ijse.backend.dto.impl.CustomerDTO;
import lk.ijse.backend.dto.impl.ItemDTO;
import lk.ijse.backend.dto.impl.OrderDTO;
import lk.ijse.backend.dto.impl.OrderDetailDTO;
import lk.ijse.backend.entity.impl.CustomerEntity;
import lk.ijse.backend.entity.impl.ItemEntity;
import lk.ijse.backend.entity.impl.OrderDetailsEntity;
import lk.ijse.backend.entity.impl.OrderEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    //matters of CustomerEntity and DTO
    public CustomerDTO convertToCustomerDTO(CustomerEntity customerEntity) {return modelMapper.map(customerEntity, CustomerDTO.class);}
    public CustomerEntity convertToCustomerEntity(CustomerDTO customerDTO) {return modelMapper.map(customerDTO, CustomerEntity.class);}
    public List<CustomerDTO> convertToCustomerDTO(List<CustomerEntity> customerEntityList) {return modelMapper.map(customerEntityList, new TypeToken<List<CustomerDTO>>() {}.getType());}

    //matters of ItemEntity and DTO
    public ItemDTO convertToItemDTO(ItemEntity itemEntity) {return modelMapper.map(itemEntity, ItemDTO.class);}
    public ItemEntity convertToItemEntity(ItemDTO itemDTO) {return modelMapper.map(itemDTO, ItemEntity.class);}
    public List<ItemDTO> convertToItemDTO(List<ItemEntity> itemEntityList) {return modelMapper.map(itemEntityList, new TypeToken<List<ItemDTO>>() {}.getType());}

    //matters of OrderEntity and DTO
    public OrderEntity convertToOrderEntity(OrderDTO orderDTO) {return modelMapper.map(orderDTO, OrderEntity.class);}
    public List<OrderDTO> convertToOrderDTO(List<OrderEntity> orderEntityList) {return modelMapper.map(orderEntityList, new TypeToken<List<OrderDTO>>() {}.getType());}

    //matters of OrderDetailEntity and DTO
    public OrderDetailsEntity convertToOrderDetailEntity(OrderDetailDTO orderDetailDTO) {return modelMapper.map(orderDetailDTO, OrderDetailsEntity.class);}
}
