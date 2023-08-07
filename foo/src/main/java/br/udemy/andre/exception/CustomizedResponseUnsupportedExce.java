package br.udemy.andre.exception;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class CustomizedResponseUnsupportedExce extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptios(Exception ex, WebRequest request){

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
                                                                    ex.getMessage(), 
                                                                    request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.I_AM_A_TEAPOT);
        

    }

    @ExceptionHandler(UnsupportedExcep.class)
    public final ResponseEntity<ExceptionResponse> handleBadResquestExceptios(Exception ex, WebRequest request){

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
                                                                    ex.getMessage(), 
                                                                    request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
        

    }

}