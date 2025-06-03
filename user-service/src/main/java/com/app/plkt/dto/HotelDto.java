package com.app.plkt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {
    private Long hotelId;
    private String hotelName;
    private String hotelLocation;
    private String description;
}
