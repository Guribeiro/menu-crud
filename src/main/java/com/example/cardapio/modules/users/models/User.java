package com.example.cardapio.modules.users.models;

import com.example.cardapio.modules.users.dtos.RequestCreateUserDTO;
import com.example.cardapio.modules.users.dtos.RequestRegisterUserDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "users")
@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String role;

    public User(RequestCreateUserDTO createUserDTO) {
        this.username = createUserDTO.username();
        this.password = createUserDTO.password();
        this.role = createUserDTO.role();
    }

    public User(RequestRegisterUserDTO registerUserDTO) {
        this.username = registerUserDTO.username();
        this.password = registerUserDTO.password();
        this.role = registerUserDTO.role();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role.equals(UserRole.ADMIN.getRole())){
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER")
            );
        }else {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    };

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
