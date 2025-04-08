package com.jobtracking.job_tracking_system.service.impl;

import com.jobtracking.job_tracking_system.model.Users;
import com.jobtracking.job_tracking_system.repository.UserRepository;
import com.jobtracking.job_tracking_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
// import java.util.List;
// import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Long userRegister(String username, String email, String password, String confirmPassword, String firstName, String lastName) {
        if (username == null || email == null || password == null || confirmPassword == null) {
            return -1L;
        }
        if (!password.equals(confirmPassword)) {
            return -1L;
        }
        if (username.length() < 3 || username.length() > 25) {
            return -1L;
        }
        if (password.length() < 6 || password.length() > 30) {
            return -1L;
        }
        if (firstName != null && firstName.length() > 30) {
            return -1L;
        }
        if (lastName != null && lastName.length() > 30) {
            return -1L;
        }

        String usernameRegex = "^[A-Za-z0-9]{3,25}$";
        Matcher usernameMatcher = Pattern.compile(usernameRegex).matcher(username);
        if (!usernameMatcher.find()) {
            return -1L;
        }
        // else if (userRepository.existsByUsername(username)) {
        //     return -1L;
        // }

        String passwordRegex = "\"^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)(?=.*[^A-Za-z0-9]).{6,30}$\"";
        Matcher passwordMatcher = Pattern.compile(passwordRegex).matcher(password);
        if (!passwordMatcher.find()) {
            return -1L;
        }
        
        String emailRegex = "^[\\w\\.-]+@[\\w\\.-]+\\.[a-zA-Z]{2,}$";
        Matcher matcher = Pattern.compile(emailRegex).matcher(email);
        if (!matcher.find()) {
            return -1L;
        } else if (userRepository.existsByEmail(email)) {
            return -1L;
        }

        firstName = firstName == "" ? null : firstName;
        lastName = lastName == "" ? null : lastName;

        String nameRegex = "^[A-Za-z]$";
        Matcher nameMatcher = Pattern.compile(nameRegex).matcher(firstName);
        if (firstName != null && !nameMatcher.find()) {
            return -1L;
        }
        nameMatcher = Pattern.compile(nameRegex).matcher(lastName);
        if (lastName != null && !nameMatcher.find()) {
            return -1L;
        }

        Users user = new Users();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        Users result = userRepository.save(user);
        return result.getUserId();
    }

    // @Override
    // public Optional<User> getUserById(Long id) {
    //     return userRepository.findById(id);
    // }

    // @Override
    // public Optional<User> getUserByUsername(String username) {
    //     return userRepository.findByUsername(username);
    // }

    // @Override
    // public List<User> getAllUsers() {
    //     return userRepository.findAll();
    // }

    // @Override
    // public User updateUser(Long id, User user) {
    //     User existingUser = userRepository.findById(id)
    //             .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        
    //     existingUser.setUsername(user.getUsername());
    //     existingUser.setEmail(user.getEmail());
    //     existingUser.setFirstName(user.getFirstName());
    //     existingUser.setLastName(user.getLastName());
    //     existingUser.setRole(user.getRole());
    //     existingUser.setStatus(user.getStatus());
        
    //     return userRepository.save(existingUser);
    // }

    // @Override
    // public void deleteUser(Long id) {
    //     userRepository.deleteById(id);
    // }

    // @Override
    // public boolean existsByUsername(String username) {
    //     return userRepository.existsByUsername(username);
    // }

    // @Override
    // public boolean existsByEmail(String email) {
    //     return userRepository.existsByEmail(email);
    // }
} 