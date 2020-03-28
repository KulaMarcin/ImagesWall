package kula.marcin.imageswall.Service;

import kula.marcin.imageswall.model.User;
import kula.marcin.imageswall.model.UserImage;

import java.util.List;

public interface UserImageService {
    List<UserImage> findAllByUserId(User user);
    void save(UserImage userImage);
    void deleteById(int id);
}
