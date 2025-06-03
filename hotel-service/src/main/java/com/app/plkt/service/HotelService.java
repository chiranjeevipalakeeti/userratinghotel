package com.app.plkt.service;

import com.app.plkt.Dto.HotelDto;

import java.util.List;

public interface HotelService {

    HotelDto  save(HotelDto hotelDto);
    HotelDto  getHotelById(Long hotelId);
    List<HotelDto> getHotels();
}
