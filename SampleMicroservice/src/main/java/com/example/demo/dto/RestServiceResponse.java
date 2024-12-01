package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RestServiceResponse {
	private boolean error;
	private Integer code;
	private String errorMessage;
	private String message;
	private List<Object> data;
	private List<String> errorList;
	public RestServiceResponse(boolean error, Integer code, String errorMessage) {
		this.error = error;
		this.code = code;
		this.errorMessage = errorMessage;
	}
	
}
