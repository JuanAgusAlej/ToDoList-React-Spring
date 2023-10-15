package com.PracticaSpring.Models.Person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Agrega gettet y setter a los parametros
@AllArgsConstructor // Crea un constructor con todos los parametros
@NoArgsConstructor
public class PersonDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

}
