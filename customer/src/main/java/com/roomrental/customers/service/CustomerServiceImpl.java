package com.roomrental.customers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roomrental.customers.feign.RoomBookingClient;
import com.roomrental.customers.feign.RoomDetailsClient;
import com.roomrental.customers.model.BookingResponse;
import com.roomrental.customers.model.RoomDetailsPojo;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private RoomDetailsClient roomClient;
	
	@Autowired 
	private RoomBookingClient bookingClient;
	
	@Override
	public BookingResponse bookRoom(String roomId) {
		
		//Communicate With BookingRoom Microservice
		return bookingClient.bookRoom(roomId);
	}

}
