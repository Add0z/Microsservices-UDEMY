package br.udemy.andre.person.PersonVO;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;




@JsonPropertyOrder({"key", "name", "surname", "address", "gender"})
public  class PersonVO extends RepresentationModel<PersonVO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    @Mapping("id")
    private Long key;

    private String name;

    private String surname;

    private String address;

    private String gender;

    public PersonVO() {}

    public PersonVO(Long key , String name, String surname, String address, String gender) {
        this.key = key;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.gender = gender;
    }

    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PersonVO other = (PersonVO) obj;
        if (key == null && other.key != null) {
            return false;
        } else if (!key.equals(other.key)) {return false;}
        if (name == null && other.name != null) {
            return false;
        } else if (!name.equals(other.name)) {return false;}
        if (surname == null && other.surname != null) {return false;} else if (!surname.equals(other.surname)) {return false;}
        if (address == null && other.address != null) {return false;} else if (!address.equals(other.address)) {return false;}
        if (gender == null && other.gender != null) {
            return false;
        } else if (!gender.equals(other.gender)) {return false;}
        return true;
    }



    public Long getKey() {
        return key;
    }

    public void setKey(Long id) {
        this.key = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



}
