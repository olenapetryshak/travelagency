package com.softserve.travelagency.controllers;

import com.softserve.travelagency.entity.Booking;
import com.softserve.travelagency.service.BookingService;
import com.softserve.travelagency.service.RoomService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Controller
public class BookingController {
    private final BookingService bookingService;
    private final RoomService roomService;

    public BookingController(BookingService bookingService, RoomService roomService) {
        this.bookingService = bookingService;
        this.roomService = roomService;
    }

    @GetMapping("/booking")
    public String createBooking(@RequestParam Long roomId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to, Model model) {
        Booking booking = bookingService.createBooking(roomId, from, to);
        model.addAttribute("bookingId", booking.getId());
        return "successBooking";
    }

    @GetMapping("/bookings")
    public String findAllUserBookings(Model model, Principal principal) {
        List<Booking> userBookings = bookingService.findUserBookings(principal.getName());
        model.addAttribute("bookings", userBookings);
        return "bookings";
    }

    @GetMapping("/booking/{id}/cancel_page")
    public String cancelBookingPage(@PathVariable Long id, Model model) {
        Booking booking = bookingService.findById(id);
        model.addAttribute("booking", booking);
        model.addAttribute("room", roomService.findById((booking.getRoom()).getId()));
        return "cencelBooking";
    }

    @GetMapping("/booking/{id}/cancel")
    public String cancelBooking(@PathVariable Long id) {
        bookingService.removeBooking(id);
        return "successCancelBooking";
    }
}
