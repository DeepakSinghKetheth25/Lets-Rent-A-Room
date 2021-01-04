package com.roomrental.rooms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.roomrental.rooms.client.AuthorizationClient;
import com.roomrental.rooms.dao.RoomRepository;
import com.roomrental.rooms.model.RoomDetails;
import com.roomrental.rooms.model.ValidateResponse;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepository roomRepo;
	
	@Autowired 
	private AuthorizationClient authClient;
	
	@Override
	public RoomDetails addNewRoom(String header,RoomDetails room) throws Exception {
		
		//Authenticate using Auth
		ValidateResponse res = authClient.validate(header);
		if(res == null)
			 throw new Exception("Authentication Failed");
 
		if(!res.getRole().substring(1, 11).equals("ROLE_ADMIN"))
		{
			throw new Exception("Only Admin is allowed to access this feature.");
		}
		
		room.setOwnerId(res.getUsername());
//     	System.out.println(room);
		return roomRepo.save(room);
	}

	@Override
	public void deleteRoom(String header,String roomId) throws Exception {
		
		//Authenticate using Auth
		ValidateResponse res = authClient.validate(header);
 
		if(!res.getRole().substring(1, 11).equals("ROLE_ADMIN"))
		{
			throw new Exception("Only Admin is allowed to access this feature.");
		}		
		roomRepo.deleteById(roomId);
	}

	@Override
	public RoomDetails findRoom(String header,String roomId) throws Exception {
		return roomRepo.findById(roomId).orElse(null);
	}

	@Override
	public List<RoomDetails> showRooms() {
		return roomRepo.findAll();	
	}

}
