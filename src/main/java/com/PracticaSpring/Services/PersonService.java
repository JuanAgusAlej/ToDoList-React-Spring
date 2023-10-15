package com.PracticaSpring.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PracticaSpring.Models.Person.Person;
import com.PracticaSpring.Models.Person.PersonDTO;
import com.PracticaSpring.Repositoris.PersonRepositori;

import lombok.RequiredArgsConstructor;

@Service // expecifica que es un Servisio para spring
@RequiredArgsConstructor // Crea automaticamente el contructor de PersonRepositori personRepo
public class PersonService {

    @Autowired
    PersonRepositori personRepo;

    public void createdPerson(Person person) {
        personRepo.save(person);
    }

    public List<Person> getAllPerson() {

        return personRepo.findAll();
    }

    public Person getPersonId(Integer id) {

        return personRepo.findById(id).orElse(null);
    }

    public Person updatePerson(Person person) {
        return personRepo.save(person);
    }

    public void deletePerson(Integer id) {
        personRepo.deleteById(id);
    }

    public PersonDTO loadin(String user, String pass) {

        Person person = personRepo.findByUserAndPass(user, pass);
        return new PersonDTO(person.getId(), person.getFirstName(), person.getLastName(), person.getEmail());

    }

}
