package co.perfectSquare.SpringBootProject.dao;

import co.perfectSquare.SpringBootProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
