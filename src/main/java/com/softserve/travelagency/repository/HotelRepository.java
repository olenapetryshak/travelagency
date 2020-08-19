package com.softserve.travelagency.repository;

import com.softserve.travelagency.entity.Hotel;

import java.util.List;

public interface HotelRepository {
    Hotel findById(Long id);

    List<Hotel> findByCountryId(Long countryId);

    void add(Hotel hotel);

    List<Hotel> findAll();

}
