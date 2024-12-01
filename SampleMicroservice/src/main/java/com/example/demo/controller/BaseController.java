package com.example.demo.controller;

import java.util.List;

import com.example.demo.dto.RestServiceResponse;

public class BaseController {

	protected RestServiceResponse getSuccessResponse(final String message, final List<Object> data) {
		final RestServiceResponse resetServiceResponse = new RestServiceResponse(false, 200, message);
		resetServiceResponse.setData(data);
		return resetServiceResponse;
	}
	
	protected RestServiceResponse getSuccessResponse(final List<Object> data) {
		return getSuccessResponse(null,data);
	}
	protected RestServiceResponse getSucessResponse(final String message) {
		return getSuccessResponse(message,null);
	}
}
