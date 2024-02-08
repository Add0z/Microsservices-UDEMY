package UnitTest.mapper.mocks;


import br.udemy.andre.person.Model.Person;
import br.udemy.andre.person.PersonVO.PersonVO;

import java.util.ArrayList;
import java.util.List;

public class MockPerson {

    public Person mockPerson() {
        return mockPerson(0);
    }

    public PersonVO mockVOPerson() {
        return mockVOPerson(0);
    }

    public List<Person> mockPersonList() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockPerson(i));
        }
        return persons;

    }

    public List<PersonVO> mockVOPersonList() {
        List<PersonVO> persons = new ArrayList<PersonVO>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockVOPerson(i));
        }
        return persons;
    }

    public Person mockPerson(Integer number) {
        Person person = new Person();
        person.setAdress("Address Test" + number);
        person.setName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setSurname("Last Name Test" + number);
        return person;
    }

    public PersonVO mockVOPerson(Integer number) {
        PersonVO person = new PersonVO();
        person.setAddress("Address Test" + number);
        person.setName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setKey(number.longValue());
        person.setSurname("Last Name Test" + number);
        return person;
    }
}
