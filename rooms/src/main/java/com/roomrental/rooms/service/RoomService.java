package com.roomrental.rooms.service;

import com.roomrental.rooms.model.RoomDetails;

public interface RoomService {

	public RoomDetails addNewRoom(RoomDetails room);

	public void deleteRoom(String roomId);
}
