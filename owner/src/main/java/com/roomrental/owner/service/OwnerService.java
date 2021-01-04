package com.roomrental.owner.service;
import com.roomrental.owner.model.NewRoom;
import com.roomrental.owner.model.RoomResponse;

public interface OwnerService {

	public RoomResponse addRoom(String header,NewRoom newroom) throws Exception;
	
	public void deleteRoom(String header,String roomId) throws Exception;
	
}
