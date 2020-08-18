package com.softserve.travelagency.controllers;

import com.softserve.travelagency.dto.HotelDTO;
import com.softserve.travelagency.entity.Hotel;
import com.softserve.travelagency.service.CountryService;
import com.softserve.travelagency.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HotelController {

    private final HotelService hotelService;
    private final CountryService countryService;

    @Autowired
    public HotelController(HotelService hotelService, CountryService countryService) {
        this.hotelService = hotelService;
        this.countryService = countryService;
    }

    @GetMapping("countries/{id}/hotels")
    public String findByCountryId(Model model, @PathVariable(name = "id") Long countryId) {
        List<Hotel> hotels = hotelService.findHotels(countryId);
        model.addAttribute("hotels", hotels);
        return "hotels";
    }

    @GetMapping("countries/hotels")
    public String addHotel(Model model) {
        HotelDTO hotel = new HotelDTO();
        model.addAttribute("hotel", hotel);
        model.addAttribute("countries", countryService.findAll());
        return "addHotel";
    }

    @PostMapping("countries/hotels")
    public String addHotel(@ModelAttribute("hotel") HotelDTO hotel) {
        Hotel newHotel = new Hotel();
        newHotel.setId(hotel.getId());
        newHotel.setName(hotel.getName());
        newHotel.setCountry(countryService.findById(hotel.getId()));
        hotelService.addHotel(newHotel);
        return "addHotel";
    }
}
