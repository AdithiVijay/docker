package com.mindtree.shoppingCartApplication.controllerExceptionHandler;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.shoppingCartApplication.apiConfig.ApiErrorResponse;

@RestControllerAdvice
public class ControllerExceptionHandler {
	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ApiErrorResponse> serviceErrors(Exception e) {		
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ApiErrorResponse("Exception", "Failed", 400, false, true,e.getMessage()));
	}
}

