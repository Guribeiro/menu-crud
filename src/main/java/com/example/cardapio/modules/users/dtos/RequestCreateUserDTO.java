package com.example.cardapio.modules.users.dtos;

public record RequestCreateUserDTO(
        String username,
        String password,
        String role
) {}
