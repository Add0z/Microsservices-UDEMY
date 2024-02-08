package br.udemy.andre.person.Services;

import UnitTest.mapper.mocks.MockPerson;
import br.udemy.andre.person.Model.Person;
import br.udemy.andre.person.PersonVO.PersonVO;
import br.udemy.andre.person.Repository.PersonRepo;
import br.udemy.andre.person.exceptions.RequiredIsNullExcep;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    MockPerson input;

    @InjectMocks
    private PersonService service;

    @Mock
    PersonRepo personRepo;


    @BeforeEach
    void setUpMocks() throws Exception {
        input = new MockPerson();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findById() {
        Person person = input.mockPerson(1);
        person.setId(1L);

        when(personRepo.findById(1L)).thenReturn(java.util.Optional.of(person));

        var result =  service.findById(1L);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
        assertTrue(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));
        assertEquals("Address Test1", result.getAddress());
        assertEquals("First Name Test1", result.getName());
        assertEquals("Last Name Test1", result.getSurname());
        assertEquals("Female", result.getGender());

    }

    @Test
    void findAllPersons() {
        List<Person> ListPerson = input.mockPersonList();

        when(personRepo.findAll()).thenReturn(ListPerson);

        var people =  service.findAllPersons();
        assertNotNull(people);
        assertTrue(!people.isEmpty());
        assertEquals(14, people.size());

        var PersonOne =  people.get(1);
        assertNotNull(PersonOne);
        assertNotNull(PersonOne.getKey());
        assertNotNull(PersonOne.getLinks());
        assertTrue(PersonOne.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));
        assertEquals("Address Test1", PersonOne.getAddress());
        assertEquals("First Name Test1", PersonOne.getName());
        assertEquals("Last Name Test1", PersonOne.getSurname());
        assertEquals("Female", PersonOne.getGender());

        var Person4 =  people.get(4);
        assertNotNull(Person4);
        assertNotNull(Person4.getKey());
        assertNotNull(Person4.getLinks());
        assertTrue(Person4.toString().contains("links: [</api/person/v1/4>;rel=\"self\"]"));
        assertEquals("Address Test4", Person4.getAddress());
        assertEquals("First Name Test4", Person4.getName());
        assertEquals("Last Name Test4", Person4.getSurname());
        assertEquals("Male", Person4.getGender());

        var Person7 =  people.get(7);
        assertNotNull(Person7);
        assertNotNull(Person7.getKey());
        assertNotNull(Person7.getLinks());
        assertTrue(Person7.toString().contains("links: [</api/person/v1/7>;rel=\"self\"]"));
        assertEquals("Address Test7", Person7.getAddress());
        assertEquals("First Name Test7", Person7.getName());
        assertEquals("Last Name Test7", Person7.getSurname());
        assertEquals("Female", Person7.getGender());

    }

    @Test
    void updatePerson() {

        Person person = input.mockPerson(1);
        person.setId(1L);


        Person savedPerson = person;
        savedPerson.setId(1L);

        PersonVO vo = input.mockVOPerson(1);
        vo.setKey(1L);

        when(personRepo.findById(1L)).thenReturn(java.util.Optional.of(person));
        when(personRepo.save(person)).thenReturn(savedPerson);

        var result =  service.updatePerson(vo);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
        assertTrue(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));
        assertEquals("Address Test1", result.getAddress());
        assertEquals("First Name Test1", result.getName());
        assertEquals("Last Name Test1", result.getSurname());
        assertEquals("Female", result.getGender());




    }

    @Test
    void createPerson() {
        Person person = input.mockPerson(1);
        Person savedPerson = person;
        savedPerson.setId(1L);

        PersonVO vo = input.mockVOPerson(1);
        vo.setKey(1L);

        when(personRepo.save(person)).thenReturn(savedPerson);

        var result =  service.createPerson(vo);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
        assertTrue(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));
        assertEquals("Address Test1", result.getAddress());
        assertEquals("First Name Test1", result.getName());
        assertEquals("Last Name Test1", result.getSurname());
        assertEquals("Female", result.getGender());


    }

    @Test
    void createPersonNull() {

        Exception exception = assertThrows(RequiredIsNullExcep.class, () -> {
            service.createPerson(null);
        });
        String expectedMessage = "Required field is null";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));


    } @Test
    void updatePersonNull() {

        Exception exception = assertThrows(RequiredIsNullExcep.class, () -> {
            service.updatePerson(null);
        });
        String expectedMessage = "Required field is null";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));


    }

    @Test
    void deletePerson() {
        Person person = input.mockPerson(1);
        person.setId(1L);

        when(personRepo.findById(1L)).thenReturn(java.util.Optional.of(person));

        service.deletePerson(1L);
    }
}