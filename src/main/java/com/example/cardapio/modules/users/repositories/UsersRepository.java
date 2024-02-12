package com.example.cardapio.modules.users.repositories;

import com.example.cardapio.modules.users.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsersRepository extends JpaRepository<User, Long> {
    UserDetails findByUsername(String username);
}
