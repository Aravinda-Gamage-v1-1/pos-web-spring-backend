package lk.ijse.backend.service;

import jakarta.transaction.Transactional;
import lk.ijse.backend.dao.CustomerDao;
import lk.ijse.backend.dto.impl.CustomerDTO;
import lk.ijse.backend.exception.DataPersistFailedException;
import lk.ijse.backend.util.AppUtil;
import lk.ijse.backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveNote(CustomerDTO customerDTO) {
        customerDTO.setCustId(AppUtil.createCustomerId());
        var customerEntity = mapping.convertToEntity(customerDTO);
        var savedCustomer = customerDao.save(customerEntity);
        if (savedCustomer == null){
            throw new DataPersistFailedException("Cannot save customer");
        }
    }

    @Override
    public void updateNote(String custId, CustomerDTO customerDTO) {

    }

    @Override
    public void deleteNote(String custId) {

    }

    @Override
    public CustomerDTO getSelectedCustomer(String custId) {
        return null;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return List.of();
    }
}
