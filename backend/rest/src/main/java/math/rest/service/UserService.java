package math.rest.service;

import math.rest.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Long id);

    User findByUsername(String username);

    User save(User form);

    User delete(Long id);
}