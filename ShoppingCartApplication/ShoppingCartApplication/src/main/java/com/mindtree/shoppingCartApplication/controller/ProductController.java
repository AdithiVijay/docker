package com.mindtree.shoppingCartApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.shoppingCartApplication.apiConfig.ApiSuccessResponse;
import com.mindtree.shoppingCartApplication.controllerExceptionHandler.BookNotFoundException;
import com.mindtree.shoppingCartApplication.dto.ProductDto;
import com.mindtree.shoppingCartApplication.exception.ApplicationException;
import com.mindtree.shoppingCartApplication.exception.AppralNotFoundException;
import com.mindtree.shoppingCartApplication.model.Apparal;
import com.mindtree.shoppingCartApplication.model.Book;
import com.mindtree.shoppingCartApplication.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping(value="/getProductById/{productId}")
	ResponseEntity<ApiSuccessResponse> searchByProductId(@PathVariable ("productId") int productId) throws ApplicationException
	{
		return ResponseEntity.status(HttpStatus.OK)
				.body(
				new ApiSuccessResponse(" succesfull", "OK", 200,productService.searchByProductId(productId), true, false));
	}
	@GetMapping(value="/getProductByName/{productName}")
	ResponseEntity<ApiSuccessResponse> searchByProductName(@PathVariable ("productName") String productName) throws ApplicationException
	{
		return ResponseEntity.status(HttpStatus.OK)
				.body(
				new ApiSuccessResponse(" succesfull", "OK", 200,productService.searchByProductName(productName), true, false));
	}
	@GetMapping(value="/getProductByCategory/{productCategory}")
	 ResponseEntity<ApiSuccessResponse> searchByCategory(@PathVariable ("productCategory") String productCategory) throws ApplicationException 
	 {
		 return ResponseEntity.status(HttpStatus.OK)
					.body(
					new ApiSuccessResponse(" succesfull", "OK", 200,productService.searchByCategory(productCategory), true, false));
	 }
	
}
