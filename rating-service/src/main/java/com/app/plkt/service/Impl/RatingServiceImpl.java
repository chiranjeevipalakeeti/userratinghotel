package com.app.plkt.service.Impl;

import com.app.plkt.Dto.RatingDto;
import com.app.plkt.mapper.RatingMapper;
import com.app.plkt.model.Rating;
import com.app.plkt.repository.RatingRepository;
import com.app.plkt.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;
    @Override
    public RatingDto save(RatingDto ratingDto) {
        Rating rating= RatingMapper.toEntity(ratingDto);
        Rating save= ratingRepository.save(rating);
        RatingDto dto=RatingMapper.toDto(save);
        return dto;
    }

    @Override
    public RatingDto getRatingById(Long ratingId) {
        return null;
    }

    @Override
    public List<RatingDto> getRatings() {
        return List.of();
    }

    @Override
    public List<RatingDto> getRatingByUserId(Long userId) {
        List<Rating> ratings= ratingRepository.findByUserId(userId);
        List<RatingDto> ratingDtos= ratings
                .stream().map(RatingMapper::toDto).collect(Collectors.toList());

        return ratingDtos;
    }
}
