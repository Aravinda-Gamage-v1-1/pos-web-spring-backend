package lk.ijse.backend.controller;

import jakarta.validation.Valid;
import lk.ijse.backend.dto.impl.OrderDTO;
import lk.ijse.backend.exception.DataPersistFailedException;
import lk.ijse.backend.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    static Logger logger = LoggerFactory.getLogger(OrderController.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createOrder(@Valid @RequestBody OrderDTO orderDTO){
        try {
            orderService.saveOrder(orderDTO);
            logger.info("Order created" + orderDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistFailedException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/allOrders", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDTO> getAllOrders(){return orderService.getAllOrders();}
}
