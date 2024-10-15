package lk.ijse.backend.dto.impl;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lk.ijse.backend.customeObj.ItemResponse;
import lk.ijse.backend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO implements SuperDTO, ItemResponse {
    private String itemId;
    @NotBlank(message = "Name can't be blank")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Name must contain only letters")
    private String itemName;
    private int quantity;
    private double price;
}
