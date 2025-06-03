package com.app.plkt.service.Impl;

import com.app.plkt.dto.ApiResponse;
import com.app.plkt.dto.HotelDto;
import com.app.plkt.dto.RatingDto;
import com.app.plkt.dto.UserDto;
import com.app.plkt.mapper.UserMapper;
import com.app.plkt.model.User;
import com.app.plkt.repository.UserRepository;
import com.app.plkt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDto saveUser(UserDto userDto) {
        User user= UserMapper.toEntity(userDto);
        User save= userRepository.save(user);
        UserDto dto= UserMapper.toDto(save);
        return dto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return List.of();
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user= userRepository.findById(userId).orElseThrow(()-> new RuntimeException("user not found"));
       ResponseEntity<ApiResponse<List<RatingDto>>> response = restTemplate.exchange(
               "http://localhost:3003/api/v3/rating/userId/1",
               HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ApiResponse<List<RatingDto>>>() {}
        );
//        ApiResponse<List<RatingDto>> apiResponse= response.getBody();
//        List<RatingDto> ratingDtos= apiResponse.getData();

        List<RatingDto> ratingDtos = response.getBody().getData();

//        ratingDtos.stream().peek(rating->
//        {
//            HotelDto hotelDto= null;
//            hotelDto= getHotelFromService(rating.getHotelId());
//            rating.setHotelDto(hotelDto);
//
//
//        }).collect(Collectors.toList());

        List<RatingDto> enrichedRatings = ratingDtos.stream()
                .map(rating -> {
                    HotelDto hotelDto = getHotelFromService(rating.getHotelId());
                    rating.setHotelDto(hotelDto);
                    return rating;
                })
                .collect(Collectors.toList());


        UserDto userDto= UserMapper.toDto(user);
        userDto.setRatingDto(ratingDtos);
        return userDto;
    }

    private HotelDto getHotelFromService(Long hotelId) {
        ResponseEntity<ApiResponse<HotelDto>> response=
                restTemplate.exchange(
                        "http://localhost:3002/api/v2/hotel/hotelId/" + hotelId,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<ApiResponse<HotelDto>>() {}
                );
        HotelDto hotelDto= response.getBody().getData();
        return hotelDto;
    }
}
