package com.PracticaSpring.Repositoris;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PracticaSpring.Models.Person.Person;

@Repository
public interface PersonRepositori extends JpaRepository<Person, Integer> {

    public Person findByUserAndPass(String user, String pass);

}
