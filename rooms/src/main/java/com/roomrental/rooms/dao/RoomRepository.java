package com.roomrental.rooms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roomrental.rooms.model.RoomDetails;

@Repository
public interface RoomRepository extends JpaRepository<RoomDetails,String>{

}
