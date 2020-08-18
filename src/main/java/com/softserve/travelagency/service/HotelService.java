package com.softserve.travelagency.service;

import entity.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> findHotels(Long countryId);

    void addHotel(Hotel hotel);


}
