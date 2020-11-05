package com.csc394.capStoneProject.controllers;

import com.csc394.capStoneProject.dto.ReviewsDTO;
import com.csc394.capStoneProject.entities.Reviews;
import com.csc394.capStoneProject.services.ReviewsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/reviews")
public class ReviewsController {


@Autowired
    ReviewsServices reviewsServices;


@GetMapping(value = "/reviewsByTeamId/{id}")
    public ResponseEntity<List<ReviewsDTO>> getReviewsByTeamId(@PathVariable(value = "id") Long teamId){

    return ResponseEntity.ok().body(ReviewsDTO.listEntityToDTO(reviewsServices.findReviewsByTeamId(teamId)));
}

}
