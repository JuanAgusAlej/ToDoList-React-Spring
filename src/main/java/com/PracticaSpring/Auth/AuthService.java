package com.PracticaSpring.Auth;

import org.springframework.stereotype.Service;

import com.PracticaSpring.Models.Person.Person;
import com.PracticaSpring.Models.Person.Role;
import com.PracticaSpring.Repositoris.PersonRepositori;
import com.PracticaSpring.jwt.JwtServise;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final PersonRepositori personRepositori;
    private final JwtServise jwtServise;

    public AuthResponse login(LoginRequest request) {
        return null;
    }

    public AuthResponse createdPerson(RegisterRequest request) {
        Person person = Person.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .password(request.getPassword())
                .role(Role.USER)
                .build();

        personRepositori.save(person);
        return AuthResponse.builder()
                .token(jwtServise.getToken(person))
                .build();
    }

}
