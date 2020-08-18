package com.softserve.travelagency.service.impl;

import com.softserve.travelagency.entity.Country;
import com.softserve.travelagency.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Override
    public Country findById(Long id) {
        return null;
    }

    @Override
    public List<Country> findAll() {
        Country country = new Country();
        country.setId(1L);
        country.setName("Ukraine");
        return Collections.singletonList(country);
    }
}
