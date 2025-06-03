package com.app.plkt.controller;

import com.app.plkt.Dto.ApiResponse;
import com.app.plkt.Dto.HotelDto;
import com.app.plkt.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<HotelDto>> save(@RequestBody HotelDto hotelDto)
    {
        ApiResponse<HotelDto> response = new ApiResponse<>();
        HotelDto dto= hotelService.save(hotelDto);
        response.setStatusCode(200);
        response.setMessage("saved");
        response.setData(dto);
        return  ResponseEntity.ok().body(response);

    }
    @GetMapping("/hotelId/{hotelId}")
    public ResponseEntity<ApiResponse<HotelDto>> getHotelById(@PathVariable Long hotelId)
    {
        ApiResponse<HotelDto> response = new ApiResponse<>();
        HotelDto hotelDto= hotelService.getHotelById(hotelId);
        response.setStatusCode(200);
        response.setMessage("saved");
        response.setData(hotelDto);
        return  ResponseEntity.ok().body(response);

    }

}
