package com.mindtree.batsman.controllerExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.batsman.apiConfig.ApiErrorResponse;
import com.mindtree.batsman.exception.ServiceException;

@RestControllerAdvice
public class ControllerExceptionHandler {
	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ApiErrorResponse> serviceErrors(Exception e) {		
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ApiErrorResponse("Exception", "Failed", 400, false, true,e.getMessage()));
	}
}
