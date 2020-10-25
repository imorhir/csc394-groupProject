package com.csc394.capStoneProject.rating;

import com.csc394.capStoneProject.rating.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long>{
    List<Rating> findByRater(Long raterId);

    List<Rating> findByRatee(Long rateeId);
}