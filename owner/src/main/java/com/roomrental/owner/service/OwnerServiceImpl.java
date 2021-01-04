package com.roomrental.owner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.roomrental.owner.feign.AuthorizationClient;
import com.roomrental.owner.feign.RoomDetailsClient;
import com.roomrental.owner.model.NewRoom;
import com.roomrental.owner.model.RoomResponse;
import com.roomrental.owner.model.ValidateResponse;

@Service
public class OwnerServiceImpl implements OwnerService{

	@Autowired 
	private RoomDetailsClient roomClient;
	
	@Autowired 
	private AuthorizationClient authClient;
	
	@Override
	public RoomResponse addRoom(String header, NewRoom newRoom) throws Exception {
		
		//Authenticate using Auth
		ValidateResponse res = authClient.validate(header);
		
			if(!res.getRole().substring(1, 11).equals("ROLE_ADMIN"))
			{
				System.out.println(res.toString());
				throw new Exception("Only Admin is allowed to access this feature.");
			}
		 
//		Feign Communication With Room Details 
		 System.out.println("Room Obj Inside Owner Service" + newRoom);
		return roomClient.addRoom(header,newRoom); 
	}
	
	@Override
	public void deleteRoom(String header,String roomId) throws Exception {
		
		ValidateResponse res = authClient.validate(header);
		if(!res.getRole().substring(1, 11).equals("ROLE_ADMIN"))
			throw new Exception("Only Admin is allowed to access this feature.");
		roomClient.deleteRoom(header,roomId);
	}
}
