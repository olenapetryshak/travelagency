package com.softserve.travelagency;

import com.softserve.travelagency.entity.Country;
import com.softserve.travelagency.entity.Hotel;
import com.softserve.travelagency.entity.Room;
import com.softserve.travelagency.service.HotelService;
import com.softserve.travelagency.service.RoomService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TravelagencyApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(TravelagencyApplication.class, args);
//        HotelService hotelService = context.getBean(HotelService.class);
//        System.out.println(hotelService.findHotels(2L));
////        Hotel hotel = new Hotel();
////        hotel.setName("Parm");
////        Country country = new Country();
////        country.setId(1L);
////        hotel.setCountry(country);
////        hotelService.addHotel(hotel);
//        RoomService roomService = context.getBean(RoomService.class);
//        System.out.println(roomService.findRooms(2L));
//        Room room = new Room();
//        roomService.addRoomToHotel(room,2L);
//        System.out.println(roomService.findRooms(2L));
    }

}
