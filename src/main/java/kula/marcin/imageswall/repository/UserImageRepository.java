package kula.marcin.imageswall.repository;

import kula.marcin.imageswall.model.User;
import kula.marcin.imageswall.model.UserImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserImageRepository extends JpaRepository<UserImage, Integer> {
    List<UserImage> findAllByUserId(User user);
}
