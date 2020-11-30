package com.roomrental.booking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class RoomDetailsPojo {

	private String roomId;
	private String ownerId;
	private String dimensions;
	private String address;
	private double rent;
	
}
