package com.softserve.travelagency.repository.impl;

import com.softserve.travelagency.entity.Booking;
import com.softserve.travelagency.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Access;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BookingRepositoryImpl implements BookingRepository {
    private final EntityManager entityManager;

    @Autowired
    public BookingRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void createBooking(Booking booking) {
        entityManager.persist(booking);
    }

    @Override
    public List<Booking> findUserBookings(Long userId) {
        TypedQuery<Booking> query = entityManager.createQuery("select b from Booking b where b.user.id = ?1", Booking.class);
        query.setParameter(1, userId);
        return query.getResultList();
    }

    @Override
    public List<Booking> findHotelBookings(Long hotelId) {
        return null;
    }
}
