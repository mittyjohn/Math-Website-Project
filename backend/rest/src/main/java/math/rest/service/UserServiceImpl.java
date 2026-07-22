package math.rest.service;

import lombok.AllArgsConstructor;
import math.rest.entity.User;
import math.rest.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("No User matching id `" + id + "`."));
    }

    @Override
    public User findByUsername(String username) {
        return userRepository
            .findByUsername(username);
    }

    @Override
    public User save(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String result = encoder.encode(user.getPassword());
        user.setPassword(result);
        return userRepository.save(user);
    }

    @Override
    public User delete(Long id) {
        return null;
    }

}