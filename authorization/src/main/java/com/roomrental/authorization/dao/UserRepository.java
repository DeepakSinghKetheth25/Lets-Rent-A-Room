package com.roomrental.authorization.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roomrental.authorization.model.DAOUser;

@Repository
public interface UserRepository extends JpaRepository<DAOUser, String> {
	DAOUser findByUsername(String username);

}