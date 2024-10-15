package lk.ijse.backend.dto.impl;

import jakarta.validation.constraints.NotBlank;
import lk.ijse.backend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements SuperDTO {
        private String orderId;
        private String date;
        @NotBlank(message = "Customer ID can't be blank")
        private String custId;
        private List<ItemDTO> itemDTOList = new ArrayList<>();
        private double total;
        private String discount;
        private double subTotal;
        private double cash;
        private double balance;
    }
