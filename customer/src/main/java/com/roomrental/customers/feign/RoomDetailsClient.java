package com.roomrental.customers.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.roomrental.customers.model.RoomDetailsPojo;

@FeignClient(name = "Room-Client", url = "${room-client}")
public interface RoomDetailsClient {
	
	@GetMapping("/findRoom/{roomId}")
	public RoomDetailsPojo findRoom(@PathVariable("roomId") String roomId);

}
