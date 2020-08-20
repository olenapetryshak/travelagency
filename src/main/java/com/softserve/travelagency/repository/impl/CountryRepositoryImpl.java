package com.softserve.travelagency.repository.impl;

import com.softserve.travelagency.entity.Country;
import com.softserve.travelagency.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CountryRepositoryImpl implements CountryRepository {

    private final EntityManager entityManager;

    @Autowired
    public CountryRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Country findById(Long id) {
        return entityManager.find(Country.class, id);
    }

    @Override
    public List<Country> findAll() {
        TypedQuery<Country> query = entityManager.createQuery("select c from Country c", Country.class);
        return query.getResultList();
    }
}
