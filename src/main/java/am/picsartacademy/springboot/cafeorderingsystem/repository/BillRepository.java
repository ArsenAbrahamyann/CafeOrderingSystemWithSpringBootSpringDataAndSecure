package am.picsartacademy.springboot.cafeorderingsystem.repository;

import am.picsartacademy.springboot.cafeorderingsystem.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BillRepository extends JpaRepository<Bill, Long> {
    Optional<Bill> getByOrderById(Long id);
}
