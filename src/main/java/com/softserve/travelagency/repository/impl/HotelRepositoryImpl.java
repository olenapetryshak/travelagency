package com.softserve.travelagency.repository.impl;

import com.softserve.travelagency.entity.Hotel;
import com.softserve.travelagency.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class HotelRepositoryImpl implements HotelRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public HotelRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Hotel findById(Long id) {
        TypedQuery<Hotel> query = entityManager.createQuery("select h from Hotel h where h.id = ?1", Hotel.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

    @Override
    public List<Hotel> findByCountryId(Long countryId) {
        TypedQuery<Hotel> query = entityManager.createQuery("select h from Hotel h where h.country.id = ?1", Hotel.class);
        query.setParameter(1, countryId);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void add(Hotel hotel) {
        entityManager.persist(hotel);
    }

    @Override
    public List<Hotel> findAll() {
        TypedQuery<Hotel> query = entityManager.createQuery("select h from Hotel h", Hotel.class);
        return query.getResultList();
    }
}
