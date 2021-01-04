package com.roomrental.owner.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class NewRoom {

	private String ownerId;
	private String dimensions;
	private String address;
	private double rent;
	private String clientId;
}
