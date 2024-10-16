package lk.ijse.backend.dto.impl;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lk.ijse.backend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailDTO implements SuperDTO {
    private String orderId;
    @Min(value = 1, message = "Quantity must be at least one;")
    private int quantity;
    @NotBlank(message = "Item ID can't be blank")
    private String itemId;
    @Positive(message = "Price must be greater than 0")
    private double price;
}
