package com.app.plkt.service.Impl;

import com.app.plkt.Dto.HotelDto;
import com.app.plkt.mapper.HotelMapper;
import com.app.plkt.model.Hotel;
import com.app.plkt.repository.HotelRepository;
import com.app.plkt.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public HotelDto save(HotelDto hotelDto) {
        Hotel hotel= HotelMapper.toEntity(hotelDto);
        Hotel save= hotelRepository.save(hotel);
        HotelDto dto= HotelMapper.toDto(save);
        return dto;
    }

    @Override
    public HotelDto getHotelById(Long hotelId) {
        Hotel hotel= hotelRepository.findById(hotelId).orElseThrow(()-> new RuntimeException("Hotel not found"));
        HotelDto hotelDto= HotelMapper.toDto(hotel);
        return hotelDto;
    }

    @Override
    public List<HotelDto> getHotels() {
        return List.of();
    }
}
