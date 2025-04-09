package com.jobtracking.job_tracking_system.model.request;

import java.io.Serializable;
import lombok.Data;

/**
 * User registration request model
 */
@Data
public class UserRegisterRequest implements Serializable{
    private static final long serialVersionUID = 1L;
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
}
