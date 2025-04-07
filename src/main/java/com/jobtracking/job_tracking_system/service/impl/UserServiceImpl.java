package com.jobtracking.job_tracking_system.service.impl;

import com.jobtracking.job_tracking_system.model.Users;
import com.jobtracking.job_tracking_system.repository.UserRepository;
import com.jobtracking.job_tracking_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// import java.util.List;
// import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Long userRegister(Users user) {
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