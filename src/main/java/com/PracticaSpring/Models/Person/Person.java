package com.PracticaSpring.Models.Person;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Agrega gettet y setter a los parametros
@AllArgsConstructor // Crea un constructor con todos los parametros
@NoArgsConstructor // Crea un contructor vacio
@Entity
public class Person {
    @Id // identificador Primary Key
    @GeneratedValue
    private Integer id;
    @Basic
    private String firstName;
    private String lastName;
    private String email;
    private String user;
    private String pass;
}
