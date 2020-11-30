package com.roomrental.customers.service;

import com.roomrental.customers.model.BookingResponse;

public interface CustomerService {

	public BookingResponse bookRoom(String roomId);
}
