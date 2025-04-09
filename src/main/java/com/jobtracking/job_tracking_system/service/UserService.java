package com.jobtracking.job_tracking_system.service;

import com.jobtracking.job_tracking_system.model.Users;
// import java.util.List;
// import java.util.Optional;

/**
 * user service
 */
public interface UserService {
    /**
     * user register
     * @param username, email, password, confirmPassword, firstName, lastName
     * @return user id
     */
    Long userRegister(String username, String email, String password, String confirmPassword, String firstName, String lastName);

   
    // Optional<Users> getUserById(Long id);


    // Optional<Users> getUserByUsername(String username);


    // List<Users> getAllUsers();


    // Users updateUser(Long id, Users user);


    // void deleteUser(Long id);


    // boolean existsByUsername(String username);


    // boolean existsByEmail(String email);
} 