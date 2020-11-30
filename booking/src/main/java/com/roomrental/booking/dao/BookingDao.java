package com.roomrental.booking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roomrental.booking.model.BookingResponse;

public interface BookingDao extends JpaRepository<BookingResponse,String>{

}
