package com.softserve.travelagency.repository;

import com.softserve.travelagency.entity.Country;

public interface CountryRepository {
    Country findById(Long id);
}
