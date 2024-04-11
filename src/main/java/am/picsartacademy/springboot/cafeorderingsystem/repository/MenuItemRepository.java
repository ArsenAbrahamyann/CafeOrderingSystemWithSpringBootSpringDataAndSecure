package am.picsartacademy.springboot.cafeorderingsystem.repository;

import am.picsartacademy.springboot.cafeorderingsystem.entities.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
