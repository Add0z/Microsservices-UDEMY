package br.udemy.andre.person.Model;

import java.io.Serializable;

public  class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String surname;

    private String address;

    private String gender;

    public Person() {}

    public Person(Long id ,String name, String surname, String adress, String gender) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = adress;
        this.gender = gender;
    }

    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Person other = (Person) obj;
        if (id == null && other.id != null) {
            return false;
        } else if (!id.equals(other.id)) {return false;}
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

    public String getAdress() {
        return address;
    }

    public void setAdress(String adress) {
        this.address = adress;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    
    
}
