package br.udemy.andre.person.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredIsNullExcep extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public RequiredIsNullExcep() {
        super("Required field is null");
    }
    public RequiredIsNullExcep(String message) {
        super(message);
    }



}


