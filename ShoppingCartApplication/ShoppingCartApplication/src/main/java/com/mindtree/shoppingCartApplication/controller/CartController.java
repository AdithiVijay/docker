package com.mindtree.shoppingCartApplication.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.shoppingCartApplication.apiConfig.ApiSuccessResponse;
import com.mindtree.shoppingCartApplication.exception.ApplicationException;
import com.mindtree.shoppingCartApplication.service.CartService;

@RestController
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@PostMapping(value="/addProductsToCart/{userID}/{productID}")
	ResponseEntity<ApiSuccessResponse> addProductsToCart(@PathVariable ("userID") int userID,@PathVariable ("productID") int productID) throws ApplicationException
	{
		return ResponseEntity.status(HttpStatus.OK)
				.body(
				new ApiSuccessResponse(" succesfull", "OK", 200,cartService.addProductsToCart(userID, productID), true, false));
	}
	@DeleteMapping(value="deleteAProduct/{userId}/{productId}")
	ResponseEntity<ApiSuccessResponse> deleteSingleProductFromCart(@PathVariable ("userId") int userId,@PathVariable ("productId") int productId) throws ApplicationException
	{
		return ResponseEntity.status(HttpStatus.OK)
				.body(
				new ApiSuccessResponse(" succesfull", "OK", 200,cartService.deleteSingleProductFromCart(userId, productId), true, false));
	}
	@DeleteMapping(value="deleteProduct/{userId}")
	ResponseEntity<ApiSuccessResponse> deleteAllProductsFromCart(@PathVariable ("userId") int userId) throws ApplicationException
	{
		return ResponseEntity.status(HttpStatus.OK)
				.body(
				new ApiSuccessResponse(" succesfull", "OK", 200,cartService.deleteAllProductsFromCart(userId), true, false));
	}
	@PutMapping(value="/update/{userId}/{productId}/{productQuantity}")
	ResponseEntity<ApiSuccessResponse> updateProductQuantity(@PathVariable ("userId") int userId,@PathVariable ("productId") int productId,@PathVariable ("productQuantity") int productQuantity) throws ApplicationException
	{
		return ResponseEntity.status(HttpStatus.OK)
				.body(
				new ApiSuccessResponse(" succesfull", "OK", 200,cartService.updateProductQuantity(userId, productId, productQuantity), true, false));
	}
	@GetMapping(value="/viewCart/{userID}")
	ResponseEntity<ApiSuccessResponse> viewCart(@PathVariable ("userID") int userID) throws ApplicationException
	{
		return ResponseEntity.status(HttpStatus.OK)
				.body(
				new ApiSuccessResponse(" succesfull", "OK", 200,cartService.viewCart(userID), true, false));
	}
}
