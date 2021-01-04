package com.roomrental.customers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.roomrental.customers.feign.AuthorizationClient;
import com.roomrental.customers.feign.RoomBookingClient;
import com.roomrental.customers.feign.RoomDetailsClient;
import com.roomrental.customers.model.BookingResponse;
import com.roomrental.customers.model.RoomDetailsPojo;
import com.roomrental.customers.model.ValidateResponse;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired 
	private RoomBookingClient bookingClient;
	
	@Autowired 
	private AuthorizationClient authClient;
	
	@Override
	public BookingResponse bookRoom(String header,String roomId) throws Exception {
		
		//Authenticate using Auth
		ValidateResponse res = authClient.validate(header);
 
		if(!res.getRole().toString().substring(1, 10).equals("ROLE_USER"))
		{
			throw new Exception("Only User is allowed to access this feature.");
		}

		//Communicate With BookingRoom Microservice 
		return bookingClient.bookRoom(header,roomId);
	}
}
