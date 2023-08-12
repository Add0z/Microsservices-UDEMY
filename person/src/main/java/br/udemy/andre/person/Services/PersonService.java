package br.udemy.andre.person.Services;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.udemy.andre.person.Model.Person;

@Service
public class PersonService{

    private final static AtomicLong counter = new AtomicLong();

    public Person findById(String id) {
        Person person = new Person();
        // person.setId(counter.incrementAndGet());
        person.setId(Long.parseLong(id));
        person.setName("Andre");
        person.setSurname("Pereira ");
        person.setAdress("Campinas");
        person.setGender("M");
        return person;
        
    }

    public  List<Person> findAllPersons() {
        List<Person> persons = new java.util.ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public  Person updatePerson(Person person) {
        return person;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setName("PersonName" + i);
        person.setSurname("Surname " + i);
        person.setAdress("Address" + i);
        person.setGender("M" + i);
        return person;
    }

    public Person createPerson(Person person) {
        return person;
    }

    public void deletePerson(String id) {}
    
}
