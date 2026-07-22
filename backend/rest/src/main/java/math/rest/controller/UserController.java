package math.rest.controller;

import lombok.AllArgsConstructor;
import math.rest.entity.User;
import math.rest.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public List<User> allUsers() {
        return userService.findAll();
    }

    @GetMapping("/id/{id}")
    public User findUserById(
        @PathVariable Long id
    ) {
        return userService.findById(id);
    }

    @GetMapping("/usr/{username}")
    public User findUserByUsername(
        @PathVariable String username
    ) {
        return userService.findByUsername(username);
    }

    @PostMapping("/add")
    User create(@RequestBody User user) {
        return userService.save(user);
    }

}