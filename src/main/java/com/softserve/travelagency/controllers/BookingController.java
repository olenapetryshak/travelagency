package com.softserve.travelagency.controllers;

import com.softserve.travelagency.entity.Booking;
import com.softserve.travelagency.service.BookingService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Controller
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/booking")
    public String createBooking(@RequestParam Long roomId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to, Model model) {
        Booking booking = bookingService.createBooking(roomId, from, to);
        model.addAttribute("bookingId",booking.getId());
        return "successBooking";
    }
    @GetMapping("/bookings")
    public String findAllUserBookings(Model model, Principal principal) {
        List<Booking> userBookings = bookingService.findUserBookings(principal.getName());
        model.addAttribute("bookings",userBookings);
        return "bookings";
    }
}
