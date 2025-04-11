package sk.malajter.task_management_system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.malajter.task_management_system.api.UserService;
import sk.malajter.task_management_system.api.request.UserAddRequest;
import sk.malajter.task_management_system.domain.User;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok().body(userService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getById(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(userService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> add(@RequestBody UserAddRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.add(request));
    }
}
