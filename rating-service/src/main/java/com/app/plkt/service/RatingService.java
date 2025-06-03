package com.app.plkt.service;

import com.app.plkt.Dto.RatingDto;

import java.util.List;

public interface RatingService {
    RatingDto save(RatingDto ratingDto);
    RatingDto getRatingById(Long ratingId);
    List<RatingDto> getRatings();
    List<RatingDto> getRatingByUserId(Long userId);
}
