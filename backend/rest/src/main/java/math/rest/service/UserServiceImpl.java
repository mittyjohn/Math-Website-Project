package math.rest.service;

import lombok.AllArgsConstructor;
import math.rest.entity.User;
import math.rest.exception.ResourceNotFoundException;
import math.rest.exception.UsernameNotFound;
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
            .orElseThrow(() -> new ResourceNotFoundException("User", id));
    }

    @Override
    public User findByUsername(String username) {
        return userRepository
            .findByUsername(username)
            .orElseThrow(() -> new UsernameNotFound(username));
    }

    @Override
    public User create(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String result = encoder.encode(user.getPassword());
        user.setPassword(result);
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        // TODO: use transactional?? maybe, only update fields that r not null in given user obj
        User userPending = userRepository
            .findByUsername(user.getUsername())
            .orElseThrow(() -> new UsernameNotFound(user.getUsername()));
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String result = encoder.encode(user.getPassword());
            user.setPassword(result);
        } else {
            user.setPassword(userPending.getPassword());
        }
        user.setId(userPending.getId());
        return userRepository.save(user);
    }

    @Override
    public void delete(String username) {
        User userPending = userRepository
            .findByUsername(username)
            .orElseThrow(() -> new UsernameNotFound(username));
        userRepository.delete(userPending);
    }



}