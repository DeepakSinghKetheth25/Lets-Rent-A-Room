package com.roomrental.rooms.service;

import java.util.List;

import com.roomrental.rooms.model.RoomDetails;

public interface RoomService {

	public RoomDetails addNewRoom(String header, RoomDetails room) throws Exception;

	public void deleteRoom(String header,String roomId) throws Exception;

	public RoomDetails findRoom(String header, String roomId) throws Exception;

	public List<RoomDetails> showRooms();
}
