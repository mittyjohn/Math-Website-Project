package math.rest.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import math.rest.dto.UserDTO;
import math.rest.dto.LoginDTO;
import math.rest.entity.User;
import math.rest.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public List<User> allUsers() {
        return userService.findAll();
    }

    @GetMapping("/usr/{username}")
    public User findUserByUsername(
        @PathVariable String username
    ) {
        return userService.findByUsername(username);
    }

    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    User create(@Valid UserDTO user) {
        return userService.create(user);
    }

    @PutMapping(value = "/update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    User update(@Valid UserDTO user) {
        return userService.update(user);
    }

    @DeleteMapping("/del/{username}")
    void delete(@PathVariable String username) {
        userService.delete(username);
    }

    @PostMapping(value = "/login", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<Map<String, String>> login(LoginDTO user) {
        userService.login(user);
        return ResponseEntity.status(HttpStatus.OK)
            .body(Map.of("username", user.username()));
    }
}