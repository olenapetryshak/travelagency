package com.softserve.travelagency.service;

import com.softserve.travelagency.entity.Hotel;
import java.util.List;

public interface HotelService {
    Hotel findById(Long id);

    List<Hotel> findHotels(Long countryId);

    void addHotel(Hotel hotel);


    List<Hotel> findAll();
}
