package com.softserve.travelagency.controllers;

import com.softserve.travelagency.repository.UserRepository;
import com.softserve.travelagency.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ManagerController {

    private final UserRepository userRepository;
    private final BookingService bookingService;

    @Autowired
    public ManagerController(UserRepository userRepository, BookingService bookingService) {
        this.userRepository = userRepository;
        this.bookingService = bookingService;
    }

    @GetMapping("/users")
    public String findAllUsers(Model model) {
        model.addAttribute("users", userRepository.findAllUsers());
        return "users";
    }
    @GetMapping("/users/{id}/bookings")
    public String findUserBookings(Model model, @PathVariable(name ="id") Long userId){
        model.addAttribute("bookings",bookingService.findUserBookings(userId));
        return "bookings";
    }
}
