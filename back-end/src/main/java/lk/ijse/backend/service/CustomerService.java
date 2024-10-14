package lk.ijse.backend.service;

import lk.ijse.backend.customeObj.CustomerResponse;
import lk.ijse.backend.dto.impl.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> getAllCustomers();
    CustomerResponse getSelectedCustomer(String custId);
    void updateCustomer(String custId, CustomerDTO customerDTO);
    void deleteCustomer(String custId);
}
