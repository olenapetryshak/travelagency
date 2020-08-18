package com.softserve.travelagency.service;

import com.softserve.travelagency.entity.Country;

import java.util.List;

public interface CountryService {
    Country findById(Long id);

    List<Country> findAll();
}
