package br.udemy.andre.person.Services;

import java.util.List;

import br.udemy.andre.person.Model.Person;
import br.udemy.andre.person.PersonController.PersonController;
import br.udemy.andre.person.PersonVO.PersonVO;
import br.udemy.andre.person.PersonVO2.PersonVO2;
import br.udemy.andre.person.Repository.PersonRepo;
import br.udemy.andre.person.exceptions.ResourceNotFoundExcep;
import br.udemy.andre.person.mapper.PersonMapper;
import br.udemy.andre.person.mapper.custom.PersonMapper2;
import org.aspectj.weaver.ast.Var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Service
public class PersonService{

    @Autowired
    PersonRepo personRepo;

    @Autowired
    PersonMapper2 personMapper2;

    private static final Logger logger = LoggerFactory.getLogger(PersonService.class);


    public PersonVO findById(Long key) {
        logger.info("Find Person by id: " + key);

       var entity = personRepo.findById(key).orElseThrow(() -> new ResourceNotFoundExcep("Person not found for this ID"));

        PersonVO vo = PersonMapper.parseObject(entity, PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(key)).withSelfRel());
        return vo;


    }

    public  List<PersonVO> findAllPersons() {
        logger.info("Find All persons");
        var persons = PersonMapper.parseListObject(personRepo.findAll(), PersonVO.class);
        persons.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));
        return persons;
    }

    public  PersonVO updatePerson(PersonVO person) {
        logger.info("Update PersonVO");

        var entity =  personRepo.findById(person.getKey()).orElseThrow(() -> new ResourceNotFoundExcep("Person not found for this ID"));

        entity.setName(person.getName());
        entity.setSurname(person.getSurname());
        entity.setAdress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = PersonMapper.parseObject(personRepo.save(entity), PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());

        return vo;
    }

    private PersonVO mockPerson(int i) {
        PersonVO person = new PersonVO();
        person.setName("PersonName" + i);
        person.setSurname("Surname " + i);
        person.setAdress("Address" + i);
        person.setGender("M" + i);
        return person;
    }

    public PersonVO createPerson(PersonVO person) {
        logger.info("Create Person");

       var entity = PersonMapper.parseObject(person, Person.class);
       var vo = PersonMapper.parseObject(personRepo.save(entity), PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public PersonVO2 createPerson2(PersonVO2 person) {
        logger.info("Create Person2");

        var entity = PersonMapper2.convertVOToEntity(person);
        var vo = PersonMapper2.convertEntityToVO(personRepo.save(entity));
        return vo;
    }

    public void deletePerson(Long key) {
        logger.info("Delete Person");
        personRepo.deleteById(key);
    }
    
}
