package com.roomrental.customers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.roomrental.customers.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CustomerController {

	@Autowired 
	private CustomerService service;
	
	@GetMapping("/bookroom/{roomId}")
	public ResponseEntity<?> bookRoom(@PathVariable("roomId") String roomId)
	{
		return new ResponseEntity<>(service.bookRoom(roomId),HttpStatus.CREATED);
	}

}
