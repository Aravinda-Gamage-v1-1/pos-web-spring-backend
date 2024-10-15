package lk.ijse.backend.dao;

import lk.ijse.backend.entity.impl.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDao extends JpaRepository<ItemEntity, String> {
}
