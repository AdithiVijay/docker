package com.mindtree.batsman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.batsman.apiConfig.ApiSuccessResponse;
import com.mindtree.batsman.dto.AverageDto;
import com.mindtree.batsman.dto.BatsmanDto;
import com.mindtree.batsman.dto.IncomeDto;
import com.mindtree.batsman.exception.ServiceException;
import com.mindtree.batsman.service.BatsmanInterface;

@RestController
public class BatsmanController {
@Autowired
BatsmanInterface batsmanservice;

@GetMapping("insert/{batsmanId}")
public ResponseEntity<ApiSuccessResponse> average(@PathVariable ("batsmanId") int batsmanId) throws ServiceException
{
	return ResponseEntity.status(HttpStatus.OK)
			.body(
			new ApiSuccessResponse(" succesfull", "OK", 200, batsmanservice.average(batsmanId), true, false));
}
@GetMapping("insertIncome/{batsmanId}")
public ResponseEntity<ApiSuccessResponse> income(@PathVariable ("batsmanId") int batsmanId) throws ServiceException
{
	return ResponseEntity.status(HttpStatus.OK)
			.body(
			new ApiSuccessResponse(" succesfull", "OK", 200,batsmanservice.income(batsmanId), true, false));
}
@GetMapping("sorting/{teamId}")
public ResponseEntity<ApiSuccessResponse> display(@PathVariable ("teamId") int teamId) throws ServiceException
{
	return ResponseEntity.status(HttpStatus.OK)
			.body(
			new ApiSuccessResponse(" succesfull", "OK", 200,batsmanservice.display(teamId), true, false));
}

}
