package br.udemy.andre.person.PersonVO2;


import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public  class PersonVO2 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String surname;

    private String address;

    private String gender;

    private Date birthDate;

    public PersonVO2() {}

    public PersonVO2(Long id, String name, String surname, String address, String gender, Date birthDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.gender = gender;
        this.birthDate = birthDate;
    }


    public PersonVO2(String name, String surname, String address, String gender, Date birthDate) {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonVO2 personVO2)) return false;
        return Objects.equals(getId(), personVO2.getId()) && Objects.equals(getName(), personVO2.getName()) && Objects.equals(getSurname(), personVO2.getSurname()) && Objects.equals(getAddress(), personVO2.getAddress()) && Objects.equals(getGender(), personVO2.getGender()) && Objects.equals(getBirthDate(), personVO2.getBirthDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getAddress(), getGender(), getBirthDate());
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    
    
}
