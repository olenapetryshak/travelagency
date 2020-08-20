package com.softserve.travelagency.repository.impl;

import com.softserve.travelagency.entity.Booking;
import com.softserve.travelagency.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    public Booking createBooking(Booking booking) {
        entityManager.persist(booking);
        return booking;
    }

    @Transactional
    @Override
    public void removeBooking(Long id) {
        entityManager.createQuery("delete from Booking b where b.id = ?1")
                .setParameter(1, id)
                .executeUpdate();
    }

    @Override
    public Booking findById(Long id) {
        return entityManager.find(Booking.class, id);
    }

    @Override
    public List<Booking> findUserBookings(Long userId) {
        TypedQuery<Booking> query = entityManager.createQuery("select b from Booking b where b.user.id = ?1", Booking.class);
        query.setParameter(1, userId);
        return query.getResultList();
    }

    @Override
    public List<Booking> findUserBookings(String username) {
        TypedQuery<Booking> query = entityManager.createQuery("select b from Booking b where b.user.username= ?1", Booking.class);
        query.setParameter(1, username);
        return query.getResultList();
    }
}
