package com.jobtracking.job_tracking_system.controller;

import com.jobtracking.job_tracking_system.model.Users;
import com.jobtracking.job_tracking_system.model.request.UserRegisterRequest;
import com.jobtracking.job_tracking_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Long userRegister(@RequestBody UserRegisterRequest request) {
        // if (userService.existsByUsername(user.getUsername())) {
        //     return ResponseEntity.badRequest().build();
        // }
        // if (userService.existsByEmail(user.getEmail())) {
        //     return ResponseEntity.badRequest().build();
        // }
        if (request == null) {
            return -1L;
        }
        String username = request.getUsername();
        String email = request.getEmail();
        String password = request.getPassword();
        String confirmPassword = request.getConfirmPassword();
        String firstName = request.getFirstName();
        String lastName = request.getLastName();

        if (username == null || email == null || password == null || confirmPassword == null) {
            return -1L;
        }

        // success userId, else -1L
        long result = userService.userRegister(username, email, password, confirmPassword, firstName, lastName);
        return result;
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<Users> getUserById(@PathVariable Long id) {
    //     return userService.getUserById(id)
    //             .map(ResponseEntity::ok)
    //             .orElse(ResponseEntity.notFound().build());
    // }

    // @GetMapping("/username/{username}")
    // public ResponseEntity<Users> getUserByUsername(@PathVariable String username) {
    //     return userService.getUserByUsername(username)
    //             .map(ResponseEntity::ok)
    //             .orElse(ResponseEntity.notFound().build());
    // }

    // @GetMapping
    // public ResponseEntity<List<Users>> getAllUsers() {
    //     return ResponseEntity.ok(userService.getAllUsers());
    // }

    // @PutMapping("/{id}")
    // public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users user) {
    //     return ResponseEntity.ok(userService.updateUser(id, user));
    // }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    //     userService.deleteUser(id);
    //     return ResponseEntity.ok().build();
    // }
} 