package br.udemy.andre.person.Services;

import java.util.List;

import br.udemy.andre.person.Model.Person;
import br.udemy.andre.person.PersonVO.PersonVO;
import br.udemy.andre.person.Repository.PersonRepo;
import br.udemy.andre.person.exceptions.ResourceNotFoundExcep;
import br.udemy.andre.person.mapper.PersonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonService{

    @Autowired
    PersonRepo personRepo;

    private static final Logger logger = LoggerFactory.getLogger(PersonService.class);


    public PersonVO findById(Long id) {
        logger.info("Find Person by id: " + id);

       var entity = personRepo.findById(id).orElseThrow(() -> new ResourceNotFoundExcep("Person not found for this ID"));

        return PersonMapper.parseObject(entity, PersonVO.class);
    }

    public  List<PersonVO> findAllPersons() {
        logger.info("Find All persons");
        return PersonMapper.parseListObject(personRepo.findAll(), PersonVO.class);
    }

    public  PersonVO updatePerson(PersonVO person) {
        logger.info("Update PersonVO");

        var entity =  personRepo.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundExcep("Person not found for this ID"));

        entity.setName(person.getName());
        entity.setSurname(person.getSurname());
        entity.setAdress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = PersonMapper.parseObject(personRepo.save(entity), PersonVO.class);
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
        return vo;
    }

    public void deletePerson(Long id) {
        logger.info("Delete Person");
        personRepo.deleteById(id);
    }
    
}
