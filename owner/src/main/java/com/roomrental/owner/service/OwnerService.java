package com.roomrental.owner.service;
import com.roomrental.owner.model.NewRoom;
import com.roomrental.owner.model.RoomResponse;

public interface OwnerService {

	public RoomResponse addRoom(NewRoom newroom);
	
	public void deleteRoom(String roomId);
	
}
