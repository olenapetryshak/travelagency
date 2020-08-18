package com.softserve.travelagency.service.impl;

import com.softserve.travelagency.entity.Booking;
import com.softserve.travelagency.repository.BookingRepository;
import com.softserve.travelagency.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }


    @Override
    public void createBooking(Booking booking) {
        bookingRepository.createBooking(booking);
    }

    @Override
    public List<Booking> findUserBookings(Long userId) {
        return bookingRepository.findUserBookings(userId);
    }

    @Override
    public List<Booking> findHotelBookings(Long hotelId) {
        return bookingRepository.findHotelBookings(hotelId);
    }
}
