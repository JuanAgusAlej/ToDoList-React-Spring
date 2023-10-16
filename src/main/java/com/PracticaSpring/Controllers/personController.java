package com.PracticaSpring.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.PracticaSpring.Models.Person.Person;
import com.PracticaSpring.Models.Person.PersonDTO;
import com.PracticaSpring.Services.PersonService;

import lombok.RequiredArgsConstructor;

@RestController // publica las rutas de los endpoints
@RequestMapping("/person") // la ruta con la cual a los endpoints, seria http://localhost:8080/person
@RequiredArgsConstructor //// Crea automaticamente el contructor de PersonService personService
public class personController {

    @Autowired
    PersonService personService;

    @GetMapping
    public String welcome() {
        return "Hola mundo";
    }

    @PostMapping("/create") // dicta el metodo http post, lo que esta entre parentecis es la ruta extra ej:
                            // http://localhost:8080/person/create
    public void createdPerson(@RequestBody /* esto aclara que los datos vienen por el Body */ Person person) {
        personService.createdPerson(person);
    }

    @GetMapping("/Get")
    @ResponseBody
    public List<Person> listPerson() {
        return personService.getAllPerson();
    }

    @GetMapping("/GetPerson/{id}")
    @ResponseBody
    public Person listPersonId(@PathVariable Integer id) {
        return personService.getPersonId(id);
    }

    @PutMapping("/Edit")
    @ResponseBody
    public Person editPerson(@RequestBody Person person) {
        return personService.updatePerson(person);
    }

    @DeleteMapping("/Deleted/{id}")
    public void deletePerson(@PathVariable Integer id) {
        personService.deletePerson(id);
    }

    @PostMapping("/login")
    public PersonDTO loginPerson(@RequestBody Person person) {

        return personService.loadin(person.getUser(), person.getPass());
    }

}
