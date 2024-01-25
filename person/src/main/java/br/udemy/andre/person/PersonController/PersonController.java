package br.udemy.andre.PersonVO.PersonController;

import br.udemy.andre.person.PersonVO.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.udemy.andre.person.Services.PersonService;

import java.util.List;


@RequestMapping(value = "/person")
@RestController
public class PersonController {

    @Autowired
   private PersonService PersonService;

    @RequestMapping(value = "/{id}",
                    produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public PersonVO findById(
            @PathVariable("id") Long id) {
                return PersonService.findById(id);
            }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<PersonVO> findAllPerson(){
            return PersonService.findAllPersons();
        }

    @PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE,
                                        produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO createPerson(@RequestBody PersonVO personVO) {
        return PersonService.createPerson(personVO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO updatePerson(@RequestBody PersonVO personVO){
        return PersonService.updatePerson(personVO);
    }   
    
    
    @DeleteMapping(value = "/del/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deletePerson(@PathVariable("id") Long id){
        findById(id);
        PersonService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}
            