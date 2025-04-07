package com.jobtracking.job_tracking_system.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.OffsetDateTime;


/**
 * user table
 */
@Data
@Entity
@Table(name = "users", 
       uniqueConstraints = {
           @UniqueConstraint(columnNames = "username"),
           @UniqueConstraint(columnNames = "email")
       })
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", columnDefinition = "BIGSERIAL")
    private Long userId;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "password", nullable = false, length = 256)
    private String password;

    @Column(name = "firstName", length = 50)
    private String firstName;

    @Column(name = "lastName", length = 50)
    private String lastName;
    
    @Column(name = "role", nullable = false, length = 20)
    private String role = "USER";
    
    @Column(name = "status", nullable = false, length = 20)
    private String status = "ACTIVE";

    @Column(name = "createDate", nullable = false)
    private OffsetDateTime createDate;

    @Column(name = "updateDate", nullable = false)
    private OffsetDateTime updateDate;

    @PrePersist
    protected void onCreate() {
        createDate = OffsetDateTime.now();
        updateDate = OffsetDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updateDate = OffsetDateTime.now();
    }
} 