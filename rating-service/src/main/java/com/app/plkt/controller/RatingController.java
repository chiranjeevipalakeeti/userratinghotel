package com.app.plkt.controller;

import com.app.plkt.Dto.ApiResponse;
import com.app.plkt.Dto.RatingDto;
import com.app.plkt.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<RatingDto>> save(@RequestBody RatingDto ratingDto)
    {
        ApiResponse<RatingDto> response= new ApiResponse<>();
        RatingDto dto= ratingService.save(ratingDto);
        response.setStatusCode(200);
        response.setMessage("Rating Saved");
        response.setData(dto);
        return  ResponseEntity.ok().body(response);
    }
    @GetMapping("/userId/{userId}")
    public ResponseEntity<ApiResponse<List<RatingDto>>>  ratingByUserId( @PathVariable Long  userId)
    {
        ApiResponse<List<RatingDto>> response = new ApiResponse<>();
        List<RatingDto> ratingDtos= ratingService.getRatingByUserId(userId);
        response.setStatusCode(200);
        response.setMessage("Rating Saved");
        response.setData(ratingDtos);
        return  ResponseEntity.ok().body(response);

    }
}
