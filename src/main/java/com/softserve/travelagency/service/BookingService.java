package com.softserve.travelagency.service;

import entity.Booking;

import java.util.List;

public interface BookingService {
    Booking createBooking(Booking booking);

    List<Booking>findUserBookings(Long userId);

    List<Booking>findHotelBookings(Long hotelId);


}
