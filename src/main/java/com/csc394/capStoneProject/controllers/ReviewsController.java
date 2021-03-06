package com.csc394.capStoneProject.controllers;

import com.csc394.capStoneProject.dto.ReviewsDTO;
import com.csc394.capStoneProject.repositories.ReviewsRepository;
import com.csc394.capStoneProject.services.ReviewsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api/reviews")
public class ReviewsController {

    @Autowired
    ReviewsServices reviewsService;
    @Autowired
    ReviewsRepository reviewsRepository;


    @GetMapping("/{id}")
    public ResponseEntity<ReviewsDTO> getReviewById(@PathVariable(name = "id") Long reviewId){
        return  ResponseEntity.ok().body(ReviewsDTO.entityToDTO(reviewsService.findById(reviewId)));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ReviewsDTO>> listAllReviews(){
        return  ResponseEntity.ok().body(ReviewsDTO.listEntityToDTO(reviewsService.getAllReviews()));
    }

//    @GetMapping("/teams/{id}")
//    public ResponseEntity<List<ReviewsDTO>> listReviewsByTeam(@PathVariable(name = "id") Integer teamId){
//        return  ResponseEntity.ok().body(ReviewsDTO.listEntityToDTO(reviewsService.getReviewsByTeamId(teamId)));
//    }

    @GetMapping("/users/{id}")
    public ResponseEntity<List<ReviewsDTO>> listReviewsByUser(@PathVariable(name = "id") Integer userId){
        return  ResponseEntity.ok().body(ReviewsDTO.listEntityToDTO(reviewsService.getReviewsByUserId(userId)));
    }

    // add new review
    @RequestMapping(value="/addReview", method = RequestMethod.POST )
    public ResponseEntity<ReviewsDTO> addReview(
            @Valid @RequestBody ReviewsDTO reviewsDto) {
        return ResponseEntity.ok().body(ReviewsDTO.entityToDTO(reviewsService.saveReview(ReviewsDTO.dtoToEntity(reviewsDto))));
    }

    // delete review
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteReview (@PathVariable Long id) {
        reviewsService.deleteReview(reviewsService.findById(id));
        return ResponseEntity.noContent().build();
    }

}
