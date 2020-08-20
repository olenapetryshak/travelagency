package com.softserve.travelagency.controllers;

import com.softserve.travelagency.dto.RoomDTO;
import com.softserve.travelagency.entity.Room;
import com.softserve.travelagency.service.CountryService;
import com.softserve.travelagency.service.HotelService;
import com.softserve.travelagency.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class RoomController {

    private final RoomService roomService;
    private final HotelService hotelService;
    private final CountryService countryService;

    @Autowired
    public RoomController(RoomService roomService, HotelService hotelService, CountryService countryService) {
        this.roomService = roomService;
        this.hotelService = hotelService;
        this.countryService = countryService;
    }

    @GetMapping("/hotels/{id}/find_rooms")
    public String getFindRoomsPage(Model model, @PathVariable Long id) {
        model.addAttribute("hotelId", id);
        return "find_rooms";
    }

    @PostMapping("/rooms/available")
    public String getAvailableRooms(
            @RequestParam Long hotelId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to, Model model) {
        model.addAttribute("availableRooms", roomService.findAvailableRooms(hotelId, from, to));
        model.addAttribute("from",from);
        model.addAttribute("to",to);
        return "rooms";
    }

    @GetMapping("/hotels/{id}/available_rooms")
    public String findAvailableRooms(Model model, @PathVariable(name = "id") Long hotelId,
                                     @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                                     @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
        List<Room> rooms = roomService.findAvailableRooms(hotelId, from, to);
        model.addAttribute("rooms", rooms);
        return "rooms";
    }

    @GetMapping("/hotels/{id}/rooms")
    public String addRoom(Model model, @PathVariable Long id) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setHotelId(id);
        model.addAttribute("room", roomDTO);
        return "addRoom";
    }

    @PostMapping("/rooms/new")
    public String addRoom(@ModelAttribute("room") RoomDTO roomDTO) {
        Room room = new Room();
        room.setPrice(roomDTO.getPrice());
        room.setType(roomDTO.getType());
        room.setHotel(hotelService.findById(roomDTO.getHotelId()));
        roomService.createRoom(room);
        return "successAddRoom";
    }

}
