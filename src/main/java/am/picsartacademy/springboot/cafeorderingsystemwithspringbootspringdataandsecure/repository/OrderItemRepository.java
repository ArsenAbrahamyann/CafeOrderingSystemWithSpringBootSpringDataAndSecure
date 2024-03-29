package am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.repository;

import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
