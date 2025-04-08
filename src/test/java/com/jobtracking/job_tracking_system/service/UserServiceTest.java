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
        Users user = new Users();
        user.setUsername("testconnection");
        user.setEmail("testconnection");
        user.setPassword("testconnection");
        long result = userService.userRegister(user);
        Assert.isTrue(result == 1L, "User registration failed");
    }

}