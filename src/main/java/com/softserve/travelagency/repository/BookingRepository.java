package com.softserve.travelagency.repository;

import com.softserve.travelagency.entity.Booking;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BookingRepository {
    void createBooking(Booking booking);

    List<Booking> findUserBookings(Long userId);

    List<Booking> findHotelBookings(Long hotelId);
}