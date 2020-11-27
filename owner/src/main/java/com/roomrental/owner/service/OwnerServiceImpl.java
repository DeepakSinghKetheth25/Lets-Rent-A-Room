package com.roomrental.owner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.roomrental.owner.feign.RoomDetailsClient;
import com.roomrental.owner.model.NewRoom;
import com.roomrental.owner.model.RoomResponse;

@Service
public class OwnerServiceImpl implements OwnerService{

	@Autowired 
	private RoomDetailsClient roomClient;
	
	@Override
	public RoomResponse addRoom(NewRoom newRoom) {
		
		//Authenticate using Auth
		
		
		//Feign Communication With Room Details 
		return roomClient.addRoom(newRoom); 
	}

	@Override
	public int deleteRoom(String roomId) {
		
		return roomClient.deleteRoom(roomId);
		
	}

}
