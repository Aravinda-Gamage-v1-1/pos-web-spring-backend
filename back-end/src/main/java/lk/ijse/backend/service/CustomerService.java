package lk.ijse.backend.service;

import lk.ijse.backend.dto.impl.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveNote(CustomerDTO customerDTO);
    void updateNote(String custId, CustomerDTO customerDTO);
    void deleteNote(String custId);
    CustomerDTO getSelectedCustomer(String custId);
    List<CustomerDTO> getAllCustomers();
}
