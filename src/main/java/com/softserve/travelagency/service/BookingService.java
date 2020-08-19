package com.softserve.travelagency.service;


import com.softserve.travelagency.entity.Booking;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {
    void createBooking(Booking booking);

    Booking createBooking(Long roomId, LocalDate from, LocalDate to);

    List<Booking>findUserBookings(Long userId);

    List<Booking>findUserBookings(String username);

}
