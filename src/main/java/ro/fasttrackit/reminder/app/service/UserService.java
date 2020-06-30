package ro.fasttrackit.reminder.app.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.reminder.app.domain.User;
import ro.fasttrackit.reminder.app.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(final Integer id) {
        return userRepository.findById(id);
    }

    public User getUserOrThrow(final Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find user with id " + id));
    }

    public User addUser(User newUser) {
        return userRepository.save(newUser);
    }

    public User deleteUser(int id) {
        User user = getUserOrThrow(id);
        userRepository.deleteById(id);
        return user;
    }

    public User replaceUser(int id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }
}
