package math.rest.service;

import math.rest.dto.LoginDTO;
import math.rest.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Long id);

    User findByUsername(String username);

    User create(User form);

    User update(User form);

    void delete(String username);

    boolean login(LoginDTO form);
}