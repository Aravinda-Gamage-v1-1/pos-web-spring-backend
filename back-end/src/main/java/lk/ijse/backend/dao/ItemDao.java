package lk.ijse.backend.dao;

import lk.ijse.backend.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao extends JpaRepository<ItemEntity, String> {
}
