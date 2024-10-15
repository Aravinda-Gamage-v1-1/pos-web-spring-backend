package lk.ijse.backend.dao;

import lk.ijse.backend.entity.impl.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailDao extends JpaRepository<OrderDetailsEntity, String> {
}
