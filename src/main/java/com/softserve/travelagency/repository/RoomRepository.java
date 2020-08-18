package com.softserve.travelagency.repository;

import com.softserve.travelagency.entity.Room;

import java.time.LocalDate;
import java.util.List;

public interface RoomRepository {
    public List<Room> findRooms(Long hotelId);

    public List<Room> findAvailableRooms(Long hotelId, LocalDate from, LocalDate to);

    public void addRoomToHotel(Room room, Long hotelId);
}
