package math.rest.service;

import lombok.AllArgsConstructor;
import math.rest.dto.LoginDTO;
import math.rest.entity.User;
import math.rest.exception.InvalidLoginException;
import math.rest.exception.ResourceNotFoundException;
import math.rest.exception.UsernameNotFoundException;
import math.rest.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

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
            .orElseThrow(() -> new UsernameNotFoundException(username));
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
            .orElseThrow(() -> new UsernameNotFoundException(user.getUsername()));
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            String result = passwordEncoder.encode(user.getPassword());
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
            .orElseThrow(() -> new UsernameNotFoundException(username));
        userRepository.delete(userPending);
    }

    public User login(LoginDTO user) {
        User userDB = userRepository
            .findByUsername(user.username())
            .orElseThrow(InvalidLoginException::new);
        if (passwordEncoder.matches(user.password(), userDB.getPassword())) {
            return userDB;
        }
        throw new InvalidLoginException();
    }
}