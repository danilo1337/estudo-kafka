package com.github.danilo1337.dto;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResponseDTO {
	private HttpStatus status;
	private Integer statusCode;
	private String response;
}
