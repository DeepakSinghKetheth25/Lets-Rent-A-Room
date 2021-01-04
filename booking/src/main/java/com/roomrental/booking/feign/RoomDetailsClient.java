package com.roomrental.booking.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.roomrental.booking.model.RoomDetailsPojo;

@FeignClient(name = "Room-Client", url = "${room-client}")
public interface RoomDetailsClient {
	
	@GetMapping("/findroom/{roomId}")
	public RoomDetailsPojo findRoom(@RequestHeader("Authorization")String header,@PathVariable("roomId") String roomId);

}
