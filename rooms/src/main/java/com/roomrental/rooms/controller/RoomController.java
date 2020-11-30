package com.roomrental.rooms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roomrental.rooms.model.RoomDetails;
import com.roomrental.rooms.service.RoomService;

@RestController
public class RoomController {

	@Autowired 
	private RoomService service;
	
	@GetMapping("/findroom/{roomId}")
	public RoomDetails findRoom(@PathVariable("roomId")String roomId)
	{
		return service.findRoom(roomId);
	}
	
	@PostMapping("/addroom")
	public ResponseEntity<?> addRoom(RoomDetails room)
	{
		return new ResponseEntity<>(service.addNewRoom(room),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteroom/{roomId}")
	public ResponseEntity<?> deleteRoom(@PathVariable("roomId") String roomId)
	{
		service.deleteRoom(roomId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
