package lk.ijse.backend.controller;

import lk.ijse.backend.dto.impl.CustomerDTO;
import lk.ijse.backend.exception.DataPersistFailedException;
import lk.ijse.backend.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    @Autowired
    private final CustomerService customerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveCustomer(@RequestBody CustomerDTO customerDTO) {
        System.out.println("save customer1");
        if (customerDTO == null) {
            System.out.println("save customer2");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            try {
                System.out.println("save customer3");
                customerService.saveCustomer(customerDTO);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }catch (DataPersistFailedException e) {
                System.out.println("save customer4");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }catch (Exception e) {
                System.out.println("save customer5");
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
