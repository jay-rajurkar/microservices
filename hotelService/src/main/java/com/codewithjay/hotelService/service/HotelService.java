package com.codewithjay.hotelService.service;

import com.codewithjay.hotelService.entities.Hotel;

import java.util.List;

public interface HotelService {
    public Hotel addHotel(Hotel hotel);

    Hotel getHotel(String hotelId);

    List<Hotel> getAllHotel();

    public Hotel updateHotel(Hotel hotel);

    public void deleteHotel(String hotelId);
}
