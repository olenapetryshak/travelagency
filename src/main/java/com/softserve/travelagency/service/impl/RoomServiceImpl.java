package com.softserve.travelagency.service.impl;

import com.softserve.travelagency.entity.Room;
import com.softserve.travelagency.repository.RoomRepository;
import com.softserve.travelagency.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;
@Service
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> findRooms(Long hotelId) {
        return roomRepository.findRooms(hotelId);
    }

    @Override
    public List<Room> findAvailableRooms(Long hotelId, LocalDate from, LocalDate to) {
        return roomRepository.findAvailableRooms(hotelId, from, to);
    }

    @Override
    public void addRoomToHotel(Room room, Long hotelId) {
        roomRepository.addRoomToHotel(room, hotelId);
    }
}
