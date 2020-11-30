package com.roomrental.rooms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roomrental.rooms.dao.RoomRepository;
import com.roomrental.rooms.model.RoomDetails;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepository roomRepo;
	
	@Override
	public RoomDetails addNewRoom(RoomDetails room) {
		return roomRepo.save(room);
	}

	@Override
	public void deleteRoom(String roomId) {
		 roomRepo.deleteById(roomId);
	}

	@Override
	public RoomDetails findRoom(String roomId) {
		return roomRepo.findById(roomId).orElse(null);
	}

}
