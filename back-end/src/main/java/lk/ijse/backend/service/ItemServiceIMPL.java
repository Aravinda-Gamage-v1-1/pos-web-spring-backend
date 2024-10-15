package lk.ijse.backend.service;

import jakarta.transaction.Transactional;
import lk.ijse.backend.customeObj.ItemErrorResponse;
import lk.ijse.backend.customeObj.ItemResponse;
import lk.ijse.backend.dao.ItemDao;
import lk.ijse.backend.dto.impl.ItemDTO;
import lk.ijse.backend.entity.ItemEntity;
import lk.ijse.backend.exception.DataPersistFailedException;
import lk.ijse.backend.exception.ItemNotFound;
import lk.ijse.backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ItemDao itemDao;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveItem(ItemDTO itemDTO) {
        var itemEntity = mapping.convertToItemEntity(itemDTO);
        var savedItem = itemDao.save(itemEntity);
        if (savedItem == null) {
            throw new DataPersistFailedException("Cannot save item");
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        return mapping.convertToItemDTO(itemDao.findAll());
    }

    @Override
    public ItemResponse getSelectedItem(String itemId) {
        if (itemDao.existsById(itemId)) {
            return mapping.convertToItemDTO(itemDao.getReferenceById(itemId));
        }else {
            return new ItemErrorResponse(0, "Item not found");
        }
    }

    @Override
    public void updateItem(String itemId, ItemDTO itemDTO) {
        Optional<ItemEntity> tmpItem = itemDao.findById(itemId);
        if (!tmpItem.isPresent()) {
            throw new ItemNotFound("Item not found");
        }else {
            tmpItem.get().setItemName(itemDTO.getItemName());
            tmpItem.get().setPrice(itemDTO.getPrice());
            tmpItem.get().setQuantity(itemDTO.getQuantity());
        }
    }

    @Override
    public void deleteItem(String itemId) {
        Optional<ItemEntity> findById = itemDao.findById(itemId);
        if (!findById.isPresent()) {
            throw new ItemNotFound("Item not found");
        }else {
            itemDao.deleteById(itemId);
        }
    }
}
