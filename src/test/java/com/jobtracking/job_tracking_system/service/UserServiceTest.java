package com.jobtracking.job_tracking_system.service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import com.jobtracking.job_tracking_system.model.Users;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testUserRegister() {
        // correct sample
        String username = "testuser";
        String email = "test@email.ca";
        String password = "Test123!";
        String confirmPassword = "Test123!";
        String firstName = "Test";

        Long result = 

        // incorrect username
        username = "te";

        // incorrect email
        email = "testemail.ca";

        // incorrect password
        password = "test123";

        // incorrect confirm password
        confirmPassword = "Test123";

        // incorrect first name
        firstName = "@Test";

        //long result = userService.userRegister();
        //Assert.isTrue(result == 1L, "User registration failed");
    }

}