package com.csc394.capStoneProject.rating;

import com.csc394.capStoneProject.rating.Rating;
import com.csc394.capStoneProject.team.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingService {
    @Autowired
    RatingRepository ratingRepository;

    // get all ratings
    public List<Rating> getAllRatings() {
        List<Rating> ratings = new ArrayList<Rating>();
        ratingRepository.findAll().forEach(e -> ratings.add(e));
        return ratings;
    }

    // save rating
    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    // get rating by id
    public Rating getRatingById(Long id) {
        return ratingRepository.findById(id).get();
    }

    // get ratings by rater
    public List<Rating> getRatingByRater(Long id) {
        List<Rating> ratings = new ArrayList<Rating>();
        ratingRepository.findByRater(id).forEach(e -> ratings.add(e));
        return ratings;
    }

    // get ratings by ratee
    public List<Rating> getRatingByRatee(Long id) {
        List<Rating> ratings = new ArrayList<Rating>();
        ratingRepository.findByRatee(id).forEach(e -> ratings.add(e));
        return ratings;
    }

    // update rate value
    public Rating updateRateVal(Rating rating, short val) {
        rating.setRateVal(val);
        return ratingRepository.save(rating);
    }

    // update message
    public Rating updateMessage(Rating rating, String message) {
        rating.setMessage(message);
        return ratingRepository.save(rating);
    }

    // delete rating
    public void deleteRating(Rating rating) {
        ratingRepository.delete(rating);
    }
}
