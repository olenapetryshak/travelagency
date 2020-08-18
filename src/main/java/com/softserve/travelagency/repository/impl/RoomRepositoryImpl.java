package com.softserve.travelagency.repository.impl;

import com.softserve.travelagency.entity.Room;
import com.softserve.travelagency.repository.HotelRepository;
import com.softserve.travelagency.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

@Repository
public class RoomRepositoryImpl implements RoomRepository {

    private final EntityManager entityManager;
    private final HotelRepository hotelRepository;

    @Autowired
    public RoomRepositoryImpl(EntityManager entityManager, HotelRepository hotelRepository) {
        this.entityManager = entityManager;
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Room> findRooms(Long hotelId) {
        TypedQuery<Room> query = entityManager.createQuery("select r from Room r where r.hotel.id = ?1", Room.class);
        query.setParameter(1, hotelId);
        return query.getResultList();
    }

    @Override
    public List<Room> findAvailableRooms(Long hotelId, LocalDate from, LocalDate to) {
        return null;
    }

    @Transactional
    @Override
    public void addRoomToHotel(Room room, Long hotelId) {
        room.setHotel(hotelRepository.findById(hotelId));
        entityManager.persist(room);
    }
}
