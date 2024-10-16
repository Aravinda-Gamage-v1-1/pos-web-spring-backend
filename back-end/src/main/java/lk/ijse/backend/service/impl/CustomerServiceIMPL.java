package lk.ijse.backend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.backend.customeObj.impl.CustomerErrorResponse;
import lk.ijse.backend.customeObj.CustomerResponse;
import lk.ijse.backend.dao.CustomerDao;
import lk.ijse.backend.dto.impl.CustomerDTO;
import lk.ijse.backend.entity.impl.CustomerEntity;
import lk.ijse.backend.exception.CustomerNotFound;
import lk.ijse.backend.exception.DataPersistFailedException;
import lk.ijse.backend.service.CustomerService;
import lk.ijse.backend.util.AppUtil;
import lk.ijse.backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        customerDTO.setCustId(AppUtil.createCustomerId());
        var customerEntity = mapping.convertToCustomerEntity(customerDTO);
        var savedCustomer = customerDao.save(customerEntity);
        if (savedCustomer == null && savedCustomer.getCustId() == null) {
            throw new DataPersistFailedException("Cannot save customer");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return mapping.convertToCustomerDTO(customerDao.findAll());
    }

    @Override
    public CustomerResponse getSelectedCustomer(String custId) {
        if (customerDao.existsById(custId)) {
            return mapping.convertToCustomerDTO(customerDao.getReferenceById(custId));
        }else {
            return new CustomerErrorResponse(0, "Customer not found");
        }
    }

    @Override
    public void updateCustomer(String custId, CustomerDTO customerDTO) {
        Optional<CustomerEntity> tmpCustomer = customerDao.findById(custId);
        if (!tmpCustomer.isPresent()) {
            throw new CustomerNotFound("Customer not found");
        }else {
            tmpCustomer.get().setCustName(customerDTO.getCustName());
            tmpCustomer.get().setCustSalary(customerDTO.getCustSalary());
            tmpCustomer.get().setCustAddress(customerDTO.getCustAddress());
        }
    }

    @Override
    public void deleteCustomer(String custId) {
        Optional<CustomerEntity> findById = customerDao.findById(custId);
        if (!findById.isPresent()) {
            throw new CustomerNotFound("Customer not found");
        }else {
            customerDao.deleteById(custId);
        }
    }
}
