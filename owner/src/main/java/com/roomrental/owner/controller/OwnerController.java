package com.roomrental.owner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roomrental.owner.model.NewRoom;
import com.roomrental.owner.service.OwnerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class OwnerController {

	@Autowired
	OwnerService service;
	
	
	@PostMapping("/addroom")
	public ResponseEntity<?> addRoom(NewRoom newRoom)
	{
		log.debug("addRoom() inside OwnerController");
		return new ResponseEntity<>(service.addRoom(newRoom),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deleteroom/{roomId}")
	public ResponseEntity<?> deleteRoom(@PathVariable("roomId") String roomId)
	{
		log.debug("deleteRoom() inside OwnerController");
		service.deleteRoom(roomId);
		return new ResponseEntity<>("RoomDeleted",HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
}
