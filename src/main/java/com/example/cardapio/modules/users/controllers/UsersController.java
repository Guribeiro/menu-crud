package com.example.cardapio.modules.users.controllers;

import com.example.cardapio.modules.users.models.User;
import com.example.cardapio.modules.users.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UsersController {

    @Autowired
    private UsersRepository repository;

    @GetMapping
    public List<User> listUsers(){
        return this.repository.findAll();
    }
}
