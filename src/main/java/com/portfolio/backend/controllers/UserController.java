package com.portfolio.backend.controllers;

import com.portfolio.backend.models.UserModel;
import com.portfolio.backend.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("")
    public List<UserModel> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable(value = "id") Long id) {
        UserModel user = userService.findById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/email")
    public ResponseEntity<UserModel> getOneUserByEmail(@RequestBody UserModel user) {
        UserModel userByEmail = userService.getUserByEmail(user.getEmail());
        if (userByEmail == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(userByEmail);
    }

    @PostMapping("")
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel user) {
        userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable(value = "id") Long id, @RequestBody UserModel user) {
        userService.update(id, user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(value = "id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}