package com.mindtree.shoppingCartApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.shoppingCartApplication.apiConfig.ApiSuccessResponse;
import com.mindtree.shoppingCartApplication.model.User;
import com.mindtree.shoppingCartApplication.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	@PostMapping(value="/addUser")
	public ResponseEntity<ApiSuccessResponse> addUser(User user)
	{
		return ResponseEntity.status(HttpStatus.OK)
				.body(
				new ApiSuccessResponse(" succesfull", "OK", 200,userService.addUser(user), true, false));
	}

}
