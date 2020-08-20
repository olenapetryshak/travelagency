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

    //    @GetMapping("/countries/{id}/hotels")
//    public String findByCountryId(Model model, @PathVariable(name = "id") Long countryId) {
//        List<Hotel> hotels = hotelService.findHotels(countryId);
//        model.addAttribute("hotels", hotels);
//        return "hotels";
//    }
    @GetMapping("/hotels")
    public String findAllHotels(Model model, @RequestParam(required = false) Long countryId) {
        List<Hotel> hotels;
        if (countryId != null) {
            model.addAttribute("currentCountry",countryService.findById(countryId));
            hotels = hotelService.findHotels(countryId);
        } else {
            hotels = hotelService.findAll();
        }
        model.addAttribute("hotels", hotels);
        model.addAttribute("countries", countryService.findAll());
        return "hotels";
    }

    @GetMapping("/hotels/{id}/hotel")
    public String findHotelById(@PathVariable Long id,Model model) {
        model.addAttribute("hotel",hotelService.findById(id));
        return "hotelInform";
    }

    @GetMapping("/hotels/new")
    public String addHotel(Model model) {
        HotelDTO hotel = new HotelDTO();
        model.addAttribute("hotel", hotel);
        model.addAttribute("countries", countryService.findAll());
        return "addHotel";
    }

    @PostMapping("/hotels/new")
    public String addHotel(@ModelAttribute("hotel") HotelDTO hotel, Model model) {
        Hotel newHotel = new Hotel();
        newHotel.setName(hotel.getName());
        newHotel.setCountry(countryService.findById(hotel.getCountryId()));
        hotelService.addHotel(newHotel);
        model.addAttribute("name", newHotel.getName());
        return "successAddHotel";
    }
}
