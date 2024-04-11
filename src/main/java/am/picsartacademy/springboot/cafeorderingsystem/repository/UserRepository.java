package am.picsartacademy.springboot.cafeorderingsystem.repository;

import am.picsartacademy.springboot.cafeorderingsystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUsername(String email);

}
