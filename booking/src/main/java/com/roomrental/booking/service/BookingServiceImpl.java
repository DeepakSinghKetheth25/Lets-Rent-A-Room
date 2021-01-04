package com.roomrental.booking.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.roomrental.booking.dao.BookingDao;
import com.roomrental.booking.feign.AuthorizationClient;
import com.roomrental.booking.feign.RoomDetailsClient;
import com.roomrental.booking.model.BookingResponse;
import com.roomrental.booking.model.RoomDetailsPojo;
import com.roomrental.booking.model.ValidateResponse;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private RoomDetailsClient roomClient;
	
	@Autowired
	private AuthorizationClient authClient;
	
	@Autowired
	private BookingDao bookingrepo;
	
	@Override
	public BookingResponse bookRoom(String header,String roomId) throws Exception {
		
		//Authenticate using Auth
		ValidateResponse res = authClient.validate(header);
		 
		if(!res.getRole().substring(1, 10).equals("ROLE_USER"))	
			throw new Exception("Only User is allowed to access this feature.");
		
		RoomDetailsPojo roomToBeBooked = roomClient.findRoom(header,roomId);		
		BookingResponse room = getRoom(roomToBeBooked,res);
		return bookingrepo.save(room);
	}

	
	private boolean checkRole(ResponseEntity<?> res)
	{
		ValidateResponse userdetails = (ValidateResponse) res.getBody();
		System.out.println("Current User "  + userdetails);
		
		if(userdetails.getRole().equals("ROLE_USER"))
		{
			return true;
		}
		return false;
	}
	
	private BookingResponse getRoom(RoomDetailsPojo roomToBeBooked, ValidateResponse userdetails) {
	
		
		BookingResponse room = new BookingResponse();
		room.setTransactionId(UUID.randomUUID().toString());
		room.setRoomId(roomToBeBooked.getRoomId());
		room.setOwnerId(roomToBeBooked.getOwnerId());
		room.setClientId(userdetails.getUsername());
		room.setStatus("booked");
		room.setRent(roomToBeBooked.getRent());
		
		return room;
	}

}
