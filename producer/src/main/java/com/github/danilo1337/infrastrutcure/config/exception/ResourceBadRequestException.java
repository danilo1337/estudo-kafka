package com.github.danilo1337.infrastrutcure.config.exception;

public class ResourceBadRequestException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
    public ResourceBadRequestException() {
        super();
    }

    public ResourceBadRequestException(String message) {
        super(message);
    }

    public ResourceBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceBadRequestException(Throwable cause) {
        super(cause);
    }

}
