package com.mockito.junit.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "user_id")
    private int userId;

    @NotBlank(message = "Username is required")
    @Size(max = 50, message = "Username cannot exceed 50 characters")
    @Column(name = "username", unique = true)
    private String username;

    @NotBlank(message = "Password is required")
    @Column (name = "password")
    private String password;

    @NotBlank(message = "Role is required")
    @Size(max = 15)
    @Column (name = "role")
    private String role = "ROLE_USER";
}
