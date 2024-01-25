package br.udemy.andre.person.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundExcep extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    public ResourceNotFoundExcep(String message) {
        super(message);
    }


}


