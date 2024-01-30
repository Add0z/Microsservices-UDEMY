package br.udemy.andre.person.PersonController;

import br.udemy.andre.person.PersonVO.PersonVO;
import br.udemy.andre.person.PersonVO2.PersonVO2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.udemy.andre.person.Services.PersonService;

import java.util.List;


@RequestMapping(value = "/api/person/v1")
@RestController
public class PersonController {

    @Autowired
   private PersonService PersonService;

    @GetMapping(value = "/{id}",
                    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public PersonVO findById(
            @PathVariable("id") Long id) {
                return PersonService.findById(id);
            }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<PersonVO> findAllPerson(){
            return PersonService.findAllPersons();
        }

    @PostMapping( consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                                        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public PersonVO createPerson(@RequestBody PersonVO personVO) {
        return PersonService.createPerson(personVO);
    }

    @PutMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public PersonVO updatePerson(@RequestBody PersonVO personVO){
        return PersonService.updatePerson(personVO);
    }   
    
    
    @DeleteMapping(value = "/del/{id}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> deletePerson(@PathVariable("id") Long id){
        findById(id);
        PersonService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/v2",consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public PersonVO2 createPersonV2(@RequestBody PersonVO2 personVO) {

        return PersonService.createPerson2(personVO);
    }

}
            