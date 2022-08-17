package com.example.pp_3_1_4_rest.controllers;

import com.example.pp_3_1_4_rest.entity.User;
import com.example.pp_3_1_4_rest.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/users")
public class AdminRestController {

    private final UserService userService;

    public AdminRestController(UserService userService) {this.userService = userService;}

    @GetMapping()
    public List <User> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity <User> getUserById (@PathVariable ("id") Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping
    public ResponseEntity<User> addUser (@RequestBody User user) {
        return ResponseEntity.ok(userService.add(user));
    }

    @PutMapping ("/{id}")
    public ResponseEntity<User> editUser (@RequestBody User user, @PathVariable ("id") Long id) {
        return ResponseEntity.ok(userService.update(user, id));
    }

    @DeleteMapping("/{id}")
    public void deleteUser (@PathVariable ("id") Long id) {
        userService.delete(id);
    }



}
