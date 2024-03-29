package am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.repository;

import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
}
