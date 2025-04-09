package com.jobtracking.job_tracking_system.service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import com.jobtracking.job_tracking_system.model.Users;
import com.jobtracking.job_tracking_system.repository.UserRepository;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testUserRegister() {
        // clear test data
        userRepository.deleteAll();

        // correct sample
        String username = "testuser";
        String email = "test@email.ca";
        String password = "Test123!";
        String confirmPassword = "Test123!";
        String firstName = "Test";
        
        // correct sample
        Long result = userService.userRegister(username, email, password, confirmPassword, firstName, null);
        Assert.isTrue(result > 0L, "User registration failed");
        // check if user already registered
        Users savedUser = userRepository.findByUsername(username).orElse(null);
        Assert.notNull(savedUser, "User should be saved");
        Assert.isTrue(savedUser.getUserId() > 0L, "User ID should be generated");
        Assert.isTrue(savedUser.getUsername().equals(username), "Username should match");
        Assert.isTrue(savedUser.getEmail().equals(email), "Email should match");

        // incorrect username
        username = "te";
        result = userService.userRegister(username, email, password, confirmPassword, firstName, null);
        Assert.isTrue(result == -1L, "Username check failed");

        // incorrect email
        email = "testemail.ca";
        result = userService.userRegister(username, email, password, confirmPassword, firstName, null);
        Assert.isTrue(result == -1L, "Email check failed");

        // incorrect password
        password = "test123";
        result = userService.userRegister(username, email, password, confirmPassword, firstName, null);
        Assert.isTrue(result == -1L, "Password check failed");

        // incorrect confirm password
        confirmPassword = "Test123";
        result = userService.userRegister(username, email, password, confirmPassword, firstName, null);
        Assert.isTrue(result == -1L, "Confirm password check failed");

        // incorrect first name
        firstName = "@Test";
        result = userService.userRegister(username, email, password, confirmPassword, firstName, null);
        Assert.isTrue(result == -1L, "First name check failed");
    }
}