package com.csc394.capStoneProject.services;

import com.csc394.capStoneProject.entities.Reviews;
import com.csc394.capStoneProject.repositories.ReviewsRepository;
import com.csc394.capStoneProject.repositories.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsServices {

    @Autowired
    ReviewsRepository reviewsRepository;
    @Autowired
    TeamsRepository teamsRepository;



    public List<Reviews> findReviewsByTeamId(Long teamId){

       return  reviewsRepository.findByTeams(teamsRepository.getOne(teamId));


    }
}
