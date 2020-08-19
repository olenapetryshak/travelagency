package com.softserve.travelagency.repository;

import com.softserve.travelagency.entity.Country;

import java.util.List;

public interface CountryRepository {
    Country findById(Long id);

    List<Country> findAll();
}
