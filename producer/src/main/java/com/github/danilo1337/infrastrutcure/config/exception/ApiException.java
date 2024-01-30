package com.github.danilo1337.infrastrutcure.config.exception;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;

@JsonInclude(value = Include.NON_NULL)
@Data
@Builder
public class ApiException {
	private HttpStatus status;
	private Integer statusCode;
	private String error;
	private Object causes;
}
