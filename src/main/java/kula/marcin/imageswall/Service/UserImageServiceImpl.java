package kula.marcin.imageswall.Service;

import kula.marcin.imageswall.model.User;
import kula.marcin.imageswall.model.UserImage;
import kula.marcin.imageswall.repository.UserImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserImageServiceImpl implements UserImageService {

    @Autowired
    private UserImageRepository userImageRepository;

    @Override
    public List<UserImage> findAllByUserId(User user) {
        return userImageRepository.findAllByUserId(user);
    }

    @Override
    public void save(UserImage userImage) {
        userImageRepository.save(userImage);
    }

    @Override
    public void deleteById(int id) {
        userImageRepository.deleteById(id);
    }
}
