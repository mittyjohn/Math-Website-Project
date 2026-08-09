package math.rest.service;

import math.rest.dto.LoginDTO;
import math.rest.dto.UserDTO;
import math.rest.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Long id);

    User findByUsername(String username);

    User create(UserDTO form);

    User update(UserDTO form);

    void delete(String username);

    User login(LoginDTO form);
}