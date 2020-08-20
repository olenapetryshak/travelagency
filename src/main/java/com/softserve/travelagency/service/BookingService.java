package com.softserve.travelagency.service;


import com.softserve.travelagency.entity.Booking;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {

    Booking createBooking(Long roomId, LocalDate from, LocalDate to);

    void removeBooking(Long id);

    Booking findById(Long id);

    List<Booking>findUserBookings(Long userId);

    List<Booking>findUserBookings(String username);

}
