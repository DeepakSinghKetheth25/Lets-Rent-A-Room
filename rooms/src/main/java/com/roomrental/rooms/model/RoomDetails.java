package com.roomrental.rooms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="room_details")
@ToString
public class RoomDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String roomId;
	private String ownerId;
	private String dimensions;
	
	@Column(unique=true)
	private String address;
	private double rent;
	private String clientId;
	
}
