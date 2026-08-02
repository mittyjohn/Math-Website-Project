package math.rest.service;

import lombok.AllArgsConstructor;
import math.rest.dto.LoginDTO;
import math.rest.dto.UserDTO;
import math.rest.entity.User;
import math.rest.exception.InvalidLoginException;
import math.rest.exception.ResourceNotFoundException;
import math.rest.exception.UsernameNotFoundException;
import math.rest.exception.DuplicateUsernameException;
import math.rest.mapper.UserMapper;
import math.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final UserMapper mapper;

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
    public User create(UserDTO user) {
        String result = passwordEncoder.encode(user.getPassword());
        user.setPassword(result);
        User entity = mapper.toEntity(user);
        return userRepository.save(entity);
    }

    @Override
    public User update(UserDTO dto) {
        User entity = userRepository
            .findByUsername(dto.getUsername())
            .orElseThrow(() -> new UsernameNotFoundException(dto.getUsername()));
        mapper.updateEntityFromDto(dto, entity);
         if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            String result = passwordEncoder.encode(dto.getPassword());
            entity.setPassword(result);
        }
        return userRepository.save(entity);
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