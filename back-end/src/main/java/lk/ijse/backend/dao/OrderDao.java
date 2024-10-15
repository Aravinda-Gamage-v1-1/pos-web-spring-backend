package lk.ijse.backend.dao;

import lk.ijse.backend.entity.impl.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends JpaRepository<OrderEntity, String> {
}
