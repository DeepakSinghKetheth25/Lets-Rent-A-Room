package com.roomrental.customers.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.roomrental.customers.model.BookingResponse;

@FeignClient(name="Room-Booking-Client",url="${booking-client}")
public interface RoomBookingClient {

	@GetMapping("/bookRoom/{roomId}")
	public BookingResponse bookRoom(String roomId);
}
