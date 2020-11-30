package com.roomrental.booking.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roomrental.booking.dao.BookingDao;
import com.roomrental.booking.feign.RoomDetailsClient;
import com.roomrental.booking.model.BookingResponse;
import com.roomrental.booking.model.RoomDetailsPojo;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private RoomDetailsClient roomClient;
	
	@Autowired
	private BookingDao bookingrepo;
	
	@Override
	public BookingResponse bookRoom(String roomId) {
		
		RoomDetailsPojo roomToBeBooked = roomClient.findRoom(roomId);
		
		BookingResponse room = getRoom(roomToBeBooked);
		return bookingrepo.save(room);
	}

	private BookingResponse getRoom(RoomDetailsPojo roomToBeBooked) {
	
		
		BookingResponse room = new BookingResponse();
		room.setTransactionId(UUID.randomUUID().toString());
		room.setRoomId(roomToBeBooked.getRoomId());
		room.setOwnerId(roomToBeBooked.getOwnerId());
		room.setClientId("ABC");
		room.setStatus("booked");
		room.setRent(roomToBeBooked.getRent());
		
		return room;
	}

}
