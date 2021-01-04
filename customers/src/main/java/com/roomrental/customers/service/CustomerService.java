package com.roomrental.customers.service;

import org.springframework.stereotype.Service;

import com.roomrental.customers.model.BookingResponse;

public interface CustomerService {

	public BookingResponse bookRoom(String header,String roomId) throws Exception;
}
