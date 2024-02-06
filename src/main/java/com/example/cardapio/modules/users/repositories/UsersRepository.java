package com.example.cardapio.modules.users.repositories;

import com.example.cardapio.modules.users.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {
}
