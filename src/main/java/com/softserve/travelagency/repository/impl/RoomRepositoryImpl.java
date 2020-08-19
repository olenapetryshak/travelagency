package com.softserve.travelagency.repository.impl;

import com.softserve.travelagency.entity.Booking;
import com.softserve.travelagency.entity.Room;
import com.softserve.travelagency.repository.BookingRepository;
import com.softserve.travelagency.repository.HotelRepository;
import com.softserve.travelagency.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Repository
public class RoomRepositoryImpl implements RoomRepository {

    private final EntityManager entityManager;
    private final HotelRepository hotelRepository;
    private final BookingRepository bookingRepository;

    @Autowired
    public RoomRepositoryImpl(EntityManager entityManager, HotelRepository hotelRepository, BookingRepository bookingRepository) {
        this.entityManager = entityManager;
        this.hotelRepository = hotelRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Room> findRooms(Long hotelId) {
        TypedQuery<Room> query = entityManager.createQuery("select r from Room r where r.hotel.id = ?1", Room.class);
        query.setParameter(1, hotelId);
        return query.getResultList();
    }

    @Override
    public List<Room> findAvailableRooms(Long hotelId, LocalDate from, LocalDate to) {
        TypedQuery<Room> query = entityManager.createQuery("select r from Room r left join Booking b on r.id = b.room.id where r.hotel.id = ?1 and" +
                " (b is null or b.from not between ?2 and ?3)", Room.class);

        query.setParameter(1, hotelId);
        query.setParameter(2, from);
        query.setParameter(3, to);

//        Room room = new Room();
//        room.setId(1L);
//        room.setPrice(new BigDecimal(100));
//        room.setType("Standart");
        return query.getResultList();
    }

    @Transactional
    @Override
    public void addRoomToHotel(Room room, Long hotelId) {
        room.setHotel(hotelRepository.findById(hotelId));
        entityManager.persist(room);
    }

    @Override
    public Room findById(Long roomId) {
        return entityManager.find(Room.class, roomId);
    }
}
