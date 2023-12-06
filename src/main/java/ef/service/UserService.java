package ef.service;

import ef.model.User;
import ef.repository.UserRepository;
import ef.repository.impl.UserRepoImpl;
import jakarta.transaction.Transactional;

import java.util.List;

public class UserService {
    private final UserRepository userRepository = new UserRepoImpl();

    public User getUserByID(Integer id) {
        return userRepository.getById(id);
    }

    public void deleteUserByID(Integer id) {
        userRepository.deleteById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.update(user);
    }


    public List<User> getAllUsers() {
        return userRepository.getAll();
    }
}
