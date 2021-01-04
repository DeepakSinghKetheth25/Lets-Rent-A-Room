package com.roomrental.customers.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.roomrental.customers.model.BookingResponse;

@FeignClient(name="Room-Booking-Client",url="${booking-client}")
public interface RoomBookingClient {

	@GetMapping("/bookroom/{roomId}")
	public BookingResponse bookRoom(@RequestHeader("Authorization") String header,@PathVariable("roomId")String roomId);
}
