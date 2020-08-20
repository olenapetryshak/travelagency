package com.softserve.travelagency.service.impl;

import com.softserve.travelagency.entity.Booking;
import com.softserve.travelagency.repository.BookingRepository;
import com.softserve.travelagency.service.BookingService;
import com.softserve.travelagency.service.RoomService;
import com.softserve.travelagency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final RoomService roomService;
    private final UserService userService;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, RoomService roomService, UserService userService) {
        this.bookingRepository = bookingRepository;
        this.roomService = roomService;
        this.userService = userService;
    }

    @Override
    @Transactional
    public Booking createBooking(Long roomId, LocalDate from, LocalDate to) {
        Booking booking = new Booking();
        booking.setFrom(from);
        booking.setTo(to);
        booking.setRoom(roomService.findById(roomId));
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        booking.setUser(userService.findByName(username).orElseThrow(() -> new IllegalArgumentException("user is not found")));
        return bookingRepository.createBooking(booking);
    }

    @Override
    public void removeBooking(Long id) {
        bookingRepository.removeBooking(id);
    }

    @Override
    public Booking findById(Long id) {
        return bookingRepository.findById(id);
    }


    @Override
    public List<Booking> findUserBookings(Long userId) {
        return bookingRepository.findUserBookings(userId);
    }

    @Override
    public List<Booking> findUserBookings(String username) {
        return bookingRepository.findUserBookings(username);
    }

}
