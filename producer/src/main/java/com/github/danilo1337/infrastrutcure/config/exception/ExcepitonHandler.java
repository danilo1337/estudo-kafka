package com.github.danilo1337.infrastrutcure.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class ExcepitonHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiException> handleException(Exception e) {
    	
    	ApiException apiException = ApiException.builder()
    											.status(HttpStatus.INTERNAL_SERVER_ERROR)
    											.statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
    											.error(e.getMessage())
    											.build();
    	
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiException);
    }
    
    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiException> handleBadRequestException(NoResourceFoundException e) {
    	
    	ApiException apiException = ApiException.builder()
				.status(HttpStatus.NOT_FOUND)
				.statusCode(HttpStatus.NOT_FOUND.value())
				.error(e.getMessage())
				.build();
    	
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiException);
    }

    
    @ExceptionHandler(ResourceBadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiException> handleBadRequestException(ResourceBadRequestException e) {
    	
    	ApiException apiException = ApiException.builder()
				.status(HttpStatus.BAD_REQUEST)
				.statusCode(HttpStatus.BAD_REQUEST.value())
				.error(e.getMessage())
				.build();
    	
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiException);
    }
    
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiException> handleNotFoundException(ResourceNotFoundException e) {
    	
    	ApiException apiException = ApiException.builder()
				.status(HttpStatus.NOT_FOUND)
				.statusCode(HttpStatus.NOT_FOUND.value())
				.error(e.getMessage())
				.causes(e)
				.build();
    	
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiException);
    }
}
