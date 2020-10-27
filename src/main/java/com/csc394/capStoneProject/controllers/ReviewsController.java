package com.csc394.capStoneProject.controllers;

import com.csc394.capStoneProject.entities.Teams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.csc394.capStoneProject.repositories.ReviewsRepository;
import com.csc394.capStoneProject.services.ReviewsServices;
import com.csc394.capStoneProject.entities.Reviews;

import java.util.List;

@Controller
@RequestMapping("/api/reviews")
public class ReviewsController {

    @Autowired
    ReviewsServices reviewsService;

    private final ReviewsRepository reviewsRepo;

    ReviewsController(ReviewsRepository reviewsRepo) {
        this.reviewsRepo = reviewsRepo;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reviews> getReviews(@PathVariable(name = "id") Long reviewId) {
        Reviews reviews = reviewsService.findById(reviewId);
        return ResponseEntity.ok().body(reviews);
    }

    // get all reviews
    @GetMapping("/all")
    List<Reviews> all() {
        return reviewsRepo.findAll();
    }

    // add new review
    @PostMapping("/addReview")
    Reviews newReview(@RequestBody Reviews newReview) {
        return reviewsRepo.save(newReview);
    }

    // delete review
    @DeleteMapping("/reviews/{id}")
    void deleteReview(@PathVariable Long id) {
        reviewsRepo.deleteById(id);
    }
}
