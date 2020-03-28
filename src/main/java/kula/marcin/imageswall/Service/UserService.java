package kula.marcin.imageswall.Service;

import kula.marcin.imageswall.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findByUsername(String username);
    User findById(int id);
    void save(User user);
}
