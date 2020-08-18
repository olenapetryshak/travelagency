package com.softserve.travelagency.service;


import com.softserve.travelagency.entity.Booking;

import java.util.List;

public interface BookingService {
    void createBooking(Booking booking);

    List<Booking>findUserBookings(Long userId);

    List<Booking>findHotelBookings(Long hotelId);


}
