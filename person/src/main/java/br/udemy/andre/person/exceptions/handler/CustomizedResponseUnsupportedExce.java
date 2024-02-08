package br.udemy.andre.person.exceptions.handler;
import java.util.Date;

import br.udemy.andre.person.exceptions.RequiredIsNullExcep;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.udemy.andre.person.exceptions.ExceptionResponse;
import br.udemy.andre.person.exceptions.ResourceNotFoundExcep;

@ControllerAdvice
@RestController
public class CustomizedResponseUnsupportedExce extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(
			Exception ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(),
				ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}


	@ExceptionHandler(ResourceNotFoundExcep.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundExceptions(
			Exception message, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(),
				message.getMessage(),
				request.getDescription(false));
	
		// Remove stacktrace from the exception response
		exceptionResponse.setStackTrace(null);
	
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(RequiredIsNullExcep.class)
	public final ResponseEntity<ExceptionResponse> HandleRequiredIsNullExcep(
			Exception message, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(),
				message.getMessage(),
				request.getDescription(false));

		// Remove stacktrace from the exception response
		exceptionResponse.setStackTrace(null);

		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}




