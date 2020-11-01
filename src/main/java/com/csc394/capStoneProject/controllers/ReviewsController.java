package com.csc394.capStoneProject.controllers;

import com.csc394.capStoneProject.dto.ReviewsDTO;
import com.csc394.capStoneProject.dto.UserDTO;
import com.csc394.capStoneProject.entities.Teams;
import com.csc394.capStoneProject.repositories.TeamsRepository;
import com.csc394.capStoneProject.repositories.ReviewsRepository;
import com.csc394.capStoneProject.services.ReviewsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.csc394.capStoneProject.services.ReviewsServices;
import com.csc394.capStoneProject.entities.Reviews;

import javax.validation.Valid;
import java.util.List;

@Controller
//@RequestMapping("/api/reviews")
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

    @GetMapping("/teams/{id}")
    public ResponseEntity<List<ReviewsDTO>> listReviewsByTeam(@PathVariable(name = "id") Integer teamId){
        return  ResponseEntity.ok().body(ReviewsDTO.listEntityToDTO(reviewsService.getReviewsByTeamId(teamId)));
    }

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
    @RequestMapping(value="/deleteReview/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteReview (
            @Valid @RequestBody ReviewsDTO reviewsDto, @PathVariable(name = "id") Long reviewId) {
        reviewsService.deleteReview(reviewsService.findById(reviewId));
        return ResponseEntity.noContent().build();
    }

}
