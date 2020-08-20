package com.softserve.travelagency.repository;

import com.softserve.travelagency.entity.Room;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface RoomRepository {
    List<Room> findRooms(Long hotelId);

    List<Room> findAvailableRooms(Long hotelId, LocalDate from, LocalDate to);

    void createRoom(Room room);

    Room findById(Long roomId);
}
