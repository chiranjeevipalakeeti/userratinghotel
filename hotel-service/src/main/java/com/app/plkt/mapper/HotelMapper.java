package com.app.plkt.mapper;

import com.app.plkt.Dto.HotelDto;
import com.app.plkt.model.Hotel;
import org.modelmapper.ModelMapper;

public class HotelMapper {
    public static final ModelMapper MAPPER= new ModelMapper();

    public  static HotelDto toDto(Hotel hotel)
    {
        return MAPPER.map(hotel,HotelDto.class);
    }
    public static Hotel toEntity(HotelDto  hotelDto)
    {
        return MAPPER.map(hotelDto,Hotel.class);
    }
}
