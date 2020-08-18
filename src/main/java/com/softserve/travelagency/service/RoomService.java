package com.softserve.travelagency.service;


import com.softserve.travelagency.entity.Room;

import java.time.LocalDate;
import java.util.List;

public interface RoomService {
    List<Room> findRooms(Long hotelId);

    List<Room> findAvailableRooms(Long hotelId, LocalDate from, LocalDate to);

    void addRoomToHotel(Room room, Long hotelId);
}
