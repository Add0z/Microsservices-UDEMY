package br.udemy.andre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedExcep extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public UnsupportedExcep(String exception) {
        super(exception);
    }

}
