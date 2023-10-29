package com.PracticaSpring.Models.Person;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Agrega gettet y setter a los parametros
@AllArgsConstructor // Crea un constructor con todos los parametros
@NoArgsConstructor // Crea un contructor vacio
@Entity
@Builder
@Table(name = "person"/* la tabla person */, uniqueConstraints = {
        @UniqueConstraint(columnNames = { "email", "userName" }) }/*
                                                                   * No
                                                                   * se
                                                                   * puede
                                                                   * repetir
                                                                   * el
                                                                   * email
                                                                   */)
public class Person implements UserDetails {
    @Id // identificador Primary Key
    @GeneratedValue // genra de manera automatica el id
    private Integer id;
    @Column(nullable = false) // no permite agregar datos si el email vine nulo
    private String email;
    private String firstName;
    private String lastName;
    @Column(nullable = false) // no permite agregar datos si el user vine nulo
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return List.of(new SimpleGrantedAuthority((role.name())));
    }

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
