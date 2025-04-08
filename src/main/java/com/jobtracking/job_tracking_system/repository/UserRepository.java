package com.jobtracking.job_tracking_system.repository;

import com.jobtracking.job_tracking_system.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.Optional;

/**
 * base and custom operations for users table
 */
public interface UserRepository extends JpaRepository<Users, Long> {
    /**
     * find user by username  
     * @param username
     * @return user or null if not found
     */
    // Optional<User> findByUsername(String username);

    /**
     * find user by email
     * @param email
     * @return user or null if not found
     */
    // Optional<User> findByEmail(String email);

    /**
     * check if user with username exists
     * @param username
     * @return true if user exists, false otherwise
     */
    boolean existsByUsername(String username);

    /**
     * check if user with email exists
     * @param email
     * @return true if email exists, false otherwise
     */
    boolean existsByEmail(String email);
} 