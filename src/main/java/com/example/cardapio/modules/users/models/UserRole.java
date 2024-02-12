package com.example.cardapio.modules.users.models;

public enum UserRole {
    ADMIN("admin"),

    USER("user");

    private final String role;

    UserRole(String role){
        this.role = role;
    }

    String getRole(){
        return this.role;
    }
}
