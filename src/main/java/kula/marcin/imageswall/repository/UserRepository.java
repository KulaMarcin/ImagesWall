package kula.marcin.imageswall.repository;

import kula.marcin.imageswall.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

}
