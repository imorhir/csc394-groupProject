package com.csc394.capStoneProject.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csc394.capStoneProject.repositories.ReviewsRepository;
import com.csc394.capStoneProject.entities.Reviews;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewsServices {
    @Autowired
    ReviewsRepository reviewsRepository;

    // get all reviews
    public List<Reviews> getAllReviews() {
        List<Reviews> reviews = new ArrayList<Reviews>();
        reviewsRepository.findAll().forEach(e -> reviews.add(e));
        return reviews;
    }

    // save review
    public Reviews saveReview(Reviews review) {
        return reviewsRepository.save(review);
    }

    // get review by id
    public Reviews findById(Long id) {
        return reviewsRepository.findById(id).get();
    }

    // get review by userId
    public List<Reviews> getReviewsByUserId(Integer userId) {
        List<Reviews> reviews = new ArrayList<Reviews>();
        reviewsRepository.findByUserId(userId).forEach(e -> reviews.add(e));
        return reviews;
    }

    // get review by teamId
    public List<Reviews> getReviewsByTeamId(Integer teamId) {
        List<Reviews> reviews = new ArrayList<Reviews>();
        reviewsRepository.findByTeamId(teamId).forEach(e -> reviews.add(e));
        return reviews;
    }

    // get reviews by reviewee
    public List<Reviews> getReviewByReviewer(Long id) {
        List<Reviews> reviews = new ArrayList<Reviews>();
        reviewsRepository.findByReviewerId(id).forEach(e -> reviews.add(e));
        return reviews;
    }

    // get reviews by reviewee
    public List<Reviews> getReviewByReviewee(Long id) {
        List<Reviews> reviews = new ArrayList<Reviews>();
        reviewsRepository.findByRevieweeId(id).forEach(e -> reviews.add(e));
        return reviews;
    }

    // update rate value
    public Reviews updateRateVal(Reviews reviews, Integer val) {
        reviews.setRating(val);
        return reviewsRepository.save(reviews);
    }

    // update message
    public Reviews updateMessage(Reviews reviews, String message) {
        reviews.setMessage(message);
        return reviewsRepository.save(reviews);
    }

    // delete review
    public void deleteReview(Reviews review) {
        reviewsRepository.delete(review);
    }
}
