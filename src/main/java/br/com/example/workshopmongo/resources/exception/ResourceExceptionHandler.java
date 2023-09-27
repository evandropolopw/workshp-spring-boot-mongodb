package br.com.example.workshopmongo.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.example.workshopmongo.services.exception.ObjectNotFounException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFounException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFounException e, 
			HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), 
				                              status.value(), 
				                              "Não encontrador", 
				                              e.getMessage(), 
				                              request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
