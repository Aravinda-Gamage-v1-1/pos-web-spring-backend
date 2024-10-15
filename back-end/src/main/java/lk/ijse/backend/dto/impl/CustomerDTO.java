package lk.ijse.backend.dto.impl;

import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
    @NotBlank(message = "Name is can't be blank")
    @Pattern(regexp = "^[A-Za-z]{2,30}$", message = "Name must contain only alphabets and be 2-30 characters long")
    private String custName;
    @NotBlank(message = "Address is required")
    private String custAddress;
    private String custSalary;
}
