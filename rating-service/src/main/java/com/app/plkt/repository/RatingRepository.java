package com.app.plkt.repository;

import com.app.plkt.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Long> {

    List<Rating> findByUserId(Long userId);
    Rating findByHotelId(Long hotelId);
}
