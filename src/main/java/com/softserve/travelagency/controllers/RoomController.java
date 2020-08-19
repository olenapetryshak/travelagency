package com.softserve.travelagency.controllers;

import com.softserve.travelagency.dto.HotelDTO;
import com.softserve.travelagency.dto.RoomDTO;
import com.softserve.travelagency.entity.Room;
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

    @Autowired
    public RoomController(RoomService roomService, HotelService hotelService) {
        this.roomService = roomService;
        this.hotelService = hotelService;
    }

    @GetMapping("/hotels/{id}/rooms")
    public String findRooms(Model model, @PathVariable(name = "id") Long hotelId) {
        List<Room> rooms = roomService.findRooms(hotelId);
        model.addAttribute("rooms", rooms);
        return "rooms";
    }

    @GetMapping("/hotels/{id}/available_rooms")
    public String findAvailableRooms(Model model, @PathVariable(name = "id") Long hotelId,
                                     @RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                                     @RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
        List<Room> rooms = roomService.findAvailableRooms(hotelId, from, to);
        model.addAttribute("rooms", rooms);
        return "rooms";
    }

    @GetMapping("hotels/rooms/{id}")
    public String addRoom(Model model, @PathVariable(name = "id") Long countryId) {
        RoomDTO roomDTO = new RoomDTO();
        model.addAttribute("room", roomDTO);
        model.addAttribute("hotels", hotelService.findHotels(countryId));
        return "addRoom";
    }

    @PostMapping("hotels/rooms/{id}")
    public String addRoom(@ModelAttribute("room") RoomDTO roomDTO) {
        Room room = new Room();
        room.setId(roomDTO.getId());
        room.setPrice(roomDTO.getPrice());
        room.setType(roomDTO.getType());
        room.setHotel(hotelService.findById(roomDTO.getHotelId()));
        roomService.addRoomToHotel(room, room.getHotel().getId());
        return "addRoom";

    }
}
