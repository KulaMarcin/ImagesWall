package kula.marcin.imageswall.Service;

import kula.marcin.imageswall.model.User;
import kula.marcin.imageswall.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findById(int id) {
        Optional<User> result = userRepository.findById(id);
        User user = null;

        if (result.isPresent()) {
            user = result.get();
        } else {
            throw new RuntimeException("Did not find instructor id - " + id);
        }

        return user;
    }
}
