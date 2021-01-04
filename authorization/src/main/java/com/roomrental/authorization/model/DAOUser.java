package com.roomrental.authorization.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DAOUser {

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	@Id
	private String username;
	
	@Column
	private String password;
	@Column
	private String name;
	
	@Column
	private String address;
	@Column
	private String role;

}
