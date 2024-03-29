package am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.repository;

import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.entities.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
