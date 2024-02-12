package com.example.cardapio.modules.users.dtos;

import javax.management.relation.Role;

public record RequestRegisterUserDTO(
        String username,
        String password,

        String role
) { }
