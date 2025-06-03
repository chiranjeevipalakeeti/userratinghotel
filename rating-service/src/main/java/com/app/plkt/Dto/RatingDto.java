package com.app.plkt.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingDto {
    private Long ratingId;
    private  Long userId;
    private Long hotelId;
    private Integer rating;
    private String feedBack;

}
