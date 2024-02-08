package br.udemy.andre.person.mapper.custom;


import br.udemy.andre.person.Model.Person;
import br.udemy.andre.person.PersonVO2.PersonVO2;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper2 {

    public static PersonVO2 convertEntityToVO(Person person){
        PersonVO2 vo = new PersonVO2();
        vo.setId(person.getId());
        vo.setName(person.getName());
        vo.setSurname(person.getSurname());
        vo.setAddress(person.getAddress());
        vo.setBirthDate(new Date());
        vo.setGender(person.getGender());
        return vo;
    }

    public static Person convertVOToEntity(PersonVO2 person){
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setName(person.getName());
        entity.setSurname(person.getSurname());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return entity;

    }
}
