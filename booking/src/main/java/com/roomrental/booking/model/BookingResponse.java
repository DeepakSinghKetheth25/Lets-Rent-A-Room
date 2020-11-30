package com.roomrental.booking.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="bookedrooms")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookingResponse {

	@Id
	private String transactionId;
	private String roomId;
	private String ownerId;
	private String clientId;
	private String status;
	private double rent;
	
}
