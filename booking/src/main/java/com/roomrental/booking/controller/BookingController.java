package com.roomrental.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.roomrental.booking.model.BookingResponse;
import com.roomrental.booking.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	private BookingService service;
	
	@GetMapping("/bookroom/{roomId}")
	public BookingResponse bookRoom(@PathVariable("roomId")String roomId)
	{
		return service.bookRoom(roomId);
	}
	
	
}
