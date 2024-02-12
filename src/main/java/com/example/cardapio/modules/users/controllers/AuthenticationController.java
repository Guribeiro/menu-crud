package com.example.cardapio.modules.users.controllers;

import com.example.cardapio.modules.users.dtos.RequestAuthenticateDTO;
import com.example.cardapio.modules.users.dtos.RequestRegisterUserDTO;
import com.example.cardapio.modules.users.dtos.ResponseLoginDTO;
import com.example.cardapio.modules.users.models.User;
import com.example.cardapio.modules.users.repositories.UsersRepository;
import com.example.cardapio.shared.infra.config.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private UsersRepository repository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<ResponseLoginDTO> authenticate(@RequestBody @Valid RequestAuthenticateDTO requestAuthenticateDTO){
        var usernamePassword = new UsernamePasswordAuthenticationToken(requestAuthenticateDTO.username(), requestAuthenticateDTO.password());

        var auth = this.authenticationManager.authenticate(usernamePassword);

        String token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new ResponseLoginDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RequestRegisterUserDTO requestRegisterUserDTO){
        var findUserWithSameUsername = this.repository.findByUsername(requestRegisterUserDTO.username());

        if(findUserWithSameUsername != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(requestRegisterUserDTO.password());

        var registerUser = new RequestRegisterUserDTO(requestRegisterUserDTO.username(), encryptedPassword, requestRegisterUserDTO.role());

        User user = new User(registerUser);

        this.repository.save(user);

        return ResponseEntity.ok().build();
    }

}
