package br.udemy.andre.person.PersonController;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.udemy.andre.person.Services.PersonService;

import br.udemy.andre.person.Model.Person;



@RequestMapping(value = "/person")
@RestController
public class PersonController {

    @Autowired
    PersonService PersonService = new PersonService();

    @RequestMapping(value = "/{id}",
                    produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Person findById(
            @PathVariable("id") String id) {
                return PersonService.findById(id);
            }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<Person> findAllPerson(){
            return PersonService.findAllPersons();
        }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE,
                    consumes = MediaType.APPLICATION_JSON_VALUE, 
                    method = RequestMethod.POST)
    public Person createPerson(@RequestBody Person person){
                return PersonService.createPerson(person);
        }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person updatePerson(@RequestBody Person person){
        return PersonService.updatePerson(person);
    }   
    
    
    @DeleteMapping(value = "/del/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public void deletePerson(@PathVariable("id") String id){ 
        findById(id);
        PersonService.deletePerson(id);
    }
            
            
            
            
            
}
            