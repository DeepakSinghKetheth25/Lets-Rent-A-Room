package com.roomrental.rooms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.roomrental.rooms.client.AuthorizationClient;
import com.roomrental.rooms.model.RoomDetails;
import com.roomrental.rooms.service.RoomService;

@RestController
public class RoomController {

	@Autowired 
	private RoomService service;
	
	
	@GetMapping("/findroom/{roomId}")
	public RoomDetails findRoom(@RequestHeader("Authorization") String header,@PathVariable("roomId")String roomId) throws Exception
	{	
		return service.findRoom(header,roomId);
	}
	
	@PostMapping("/addroom")
	public ResponseEntity<?> addRoom(@RequestHeader("Authorization") String header,@RequestBody RoomDetails room) throws Exception
	{
		return new ResponseEntity<>(service.addNewRoom(header,room),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteroom/{roomId}")
	public ResponseEntity<?> deleteRoom(@RequestHeader("Authorization") String header,@PathVariable("roomId") String roomId) throws Exception
	{
		service.deleteRoom(header,roomId);
		return new ResponseEntity<>(true,HttpStatus.OK);
	}
	
	@GetMapping("/showrooms")
	public ResponseEntity<?> showRooms()
	{		
		return new ResponseEntity<>(service.showRooms(),HttpStatus.OK);
	}
	
	
	
}
