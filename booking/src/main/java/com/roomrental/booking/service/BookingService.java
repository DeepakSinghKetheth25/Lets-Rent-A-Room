package com.roomrental.booking.service;

import com.roomrental.booking.model.BookingResponse;

public interface BookingService {

	public BookingResponse bookRoom(String header,String roomId) throws Exception;
	
}
