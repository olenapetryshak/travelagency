package com.softserve.travelagency.controllers;

import com.softserve.travelagency.service.BookingService;
import com.softserve.travelagency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ManagerController {

    private final UserService userService;
    private final BookingService bookingService;

    @Autowired
    public ManagerController(UserService userService, BookingService bookingService) {
        this.userService = userService;
        this.bookingService = bookingService;
    }
    @GetMapping("/manager")
    public String manager() {
        return "manager";
    }

    @GetMapping("/users")
    public String findAllUsers(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "users";
    }
    @GetMapping("/users/{id}/bookings")
    public String findUserBookings(Model model, @PathVariable(name ="id") Long userId){
        model.addAttribute("bookings",bookingService.findUserBookings(userId));
        return "bookings";
    }
}
