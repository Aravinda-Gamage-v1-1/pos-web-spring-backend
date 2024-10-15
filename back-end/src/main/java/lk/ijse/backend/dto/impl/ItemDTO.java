package lk.ijse.backend.dto.impl;

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
    private String itemName;
    private int quantity;
    private double price;
}
