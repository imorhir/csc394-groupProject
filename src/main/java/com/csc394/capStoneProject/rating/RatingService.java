package com.csc394.capStoneProject.rating;

import com.csc394.capStoneProject.user.TypeOfUser;
import com.csc394.capStoneProject.user.User;
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
}
