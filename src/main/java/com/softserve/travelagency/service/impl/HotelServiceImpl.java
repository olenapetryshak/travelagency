package com.softserve.travelagency.service.impl;

import com.softserve.travelagency.entity.Hotel;
import com.softserve.travelagency.repository.HotelRepository;
import com.softserve.travelagency.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Hotel findById(Long id) {
        return hotelRepository.findById(id);
    }

    @Override
    public List<Hotel> findHotels(Long countryId) {
        return hotelRepository.findByCountryId(countryId);
    }

    @Override
    public void addHotel(Hotel hotel) {
        hotelRepository.add(hotel);
    }

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }
}
