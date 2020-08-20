package com.softserve.travelagency.repository;

import com.softserve.travelagency.entity.Booking;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BookingRepository {
    Booking createBooking(Booking booking);

    void removeBooking(Long id);

    public Booking findById(Long id);

    List<Booking> findUserBookings(Long userId);

    List<Booking> findUserBookings(String username);
}
