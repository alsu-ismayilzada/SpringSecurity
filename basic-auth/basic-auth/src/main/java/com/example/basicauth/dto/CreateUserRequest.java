package com.example.basicauth.dto;

import com.example.basicauth.model.Role;

import java.util.Set;

public record CreateUserRequest(
        String name,
        String userName,
        String password,
        Set<Role> authorities
) {
}
