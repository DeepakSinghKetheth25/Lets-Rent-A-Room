package com.roomrental.rooms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoomDetails {

	@Id
	@GeneratedValue
	private String roomId;
	private String ownerId;
	private String dimensions;
	private String address;
	private double rent;
	private String clientId;
	
}
