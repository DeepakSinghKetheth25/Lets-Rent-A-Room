package com.roomrental.owner.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.roomrental.owner.model.NewRoom;
import com.roomrental.owner.model.RoomResponse;

@FeignClient(name = "Room-Client", url = "${room-client}")
public interface RoomDetailsClient {
	
	@PostMapping("/addroom")
	public RoomResponse addRoom(NewRoom newRoom);

	@DeleteMapping("/deleteroom/{roomId}")
	public int deleteRoom(@PathVariable("roomId") String roomId);

}
