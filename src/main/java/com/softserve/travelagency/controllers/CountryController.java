package com.softserve.travelagency.controllers;


import com.softserve.travelagency.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CountryController {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping("/countries")
    public String findAllCountries(Model model){
        model.addAttribute("countries",countryRepository.findAll());
        return "countries";
    }
}
