package com.app.plkt.mapper;

import com.app.plkt.Dto.RatingDto;
import com.app.plkt.model.Rating;
import org.modelmapper.ModelMapper;

public class RatingMapper {
    public static  final ModelMapper MAPPER= new ModelMapper();

    public static RatingDto toDto(Rating rating)
    {
        return MAPPER.map(rating,RatingDto.class);
    }

    public static Rating toEntity(RatingDto ratingDto)
    {
        return MAPPER.map(ratingDto,Rating.class);
    }
}
