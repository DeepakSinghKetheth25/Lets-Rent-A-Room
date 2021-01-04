package com.roomrental.customers.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoomDetailsPojo {

	private String roomId;
	private String ownerId;
	private String dimensions;
	private String address;
	private double rent;
	
}
