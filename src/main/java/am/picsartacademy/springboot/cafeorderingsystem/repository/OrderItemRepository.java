package am.picsartacademy.springboot.cafeorderingsystem.repository;

import am.picsartacademy.springboot.cafeorderingsystem.entities.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderDetails, Long> {
}
