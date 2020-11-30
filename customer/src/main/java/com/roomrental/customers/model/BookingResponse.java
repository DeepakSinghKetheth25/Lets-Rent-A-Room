package com.roomrental.customers.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookingResponse {

	private String transactionId;
	private String roomId;
	private String ownerId;
	private String clientId;
	private String status;
	private double rent;
	
}
