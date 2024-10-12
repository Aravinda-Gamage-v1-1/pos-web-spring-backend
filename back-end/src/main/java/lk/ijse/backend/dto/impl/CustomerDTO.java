package lk.ijse.backend.dto.impl;

import lk.ijse.backend.customeObj.CustomerResponse;
import lk.ijse.backend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements SuperDTO, CustomerResponse {
    private String custId;
    private String custName;
    private String custAddress;
    private double custSalary;
}
