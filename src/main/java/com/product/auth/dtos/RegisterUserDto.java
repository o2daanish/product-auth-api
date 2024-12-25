package com.product.code.test.dtos;

public class RegisterUserDto {
    private String username;
    private String password;
    private String role;

    public String getUsername() {
        return username;
    }

    public RegisterUserDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterUserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRole() {
        return role;
    }

    public RegisterUserDto setRole(String role) {
        this.role = role;
        return this;
    }

    @Override
    public String toString() {
        return "RegisterUserDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
