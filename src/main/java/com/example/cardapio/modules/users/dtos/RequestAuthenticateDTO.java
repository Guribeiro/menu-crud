package com.example.cardapio.modules.users.dtos;

public record RequestAuthenticateDTO(
        String username,
        String password
) {}
