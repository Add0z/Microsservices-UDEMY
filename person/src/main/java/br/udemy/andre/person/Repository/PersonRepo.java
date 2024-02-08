package br.udemy.andre.person.Repository;

import br.udemy.andre.person.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Long> {}
