package com.softserve.travelagency.service.impl;

import com.softserve.travelagency.entity.Country;
import com.softserve.travelagency.repository.CountryRepository;
import com.softserve.travelagency.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country findById(Long id) {
        return null;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }
}
