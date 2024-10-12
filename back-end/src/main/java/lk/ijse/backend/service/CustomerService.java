package lk.ijse.backend.service;

import lk.ijse.backend.dto.impl.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);
    void updateCustomer(String custId, CustomerDTO customerDTO);
    void deleteCustomer(String custId);
    CustomerDTO getSelectedCustomer(String custId);
    List<CustomerDTO> getAllCustomers();
}
