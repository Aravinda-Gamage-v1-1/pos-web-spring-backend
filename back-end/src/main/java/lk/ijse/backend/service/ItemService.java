package lk.ijse.backend.service;

import lk.ijse.backend.customeObj.ItemResponse;
import lk.ijse.backend.dto.impl.ItemDTO;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDTO itemDTO);
    List<ItemDTO> getAllItems();
    ItemResponse getSelectedItem(String itemId);
    void updateItem(String itemId, ItemDTO itemDTO);
    void deleteItem(String itemId);
}
