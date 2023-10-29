package com.PracticaSpring.Auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails userDetails = personRepositori.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtServise.getToken(userDetails);
        return AuthResponse.builder()
                .token(token).build();
    }

    public AuthResponse createdPerson(RegisterRequest request) {
        Person person = Person.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        personRepositori.save(person);
        return AuthResponse.builder()
                .token(jwtServise.getToken(person))
                .build();
    }

}
