package com.app.plkt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingDto {
    private Long ratingId;
    private  Long userId;
    private Long hotelId;
    private Integer rating;
    private String feedBack;
    private HotelDto hotelDto;

}
