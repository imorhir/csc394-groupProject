package com.csc394.capStoneProject.dto;

import com.csc394.capStoneProject.entities.Goals;
import com.csc394.capStoneProject.entities.Reviews;
import com.csc394.capStoneProject.entities.Teams;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data

public class ReviewsDTO {


    private Long id;
    private Long user_id;
    private Long teamID;
    private Integer rating;


    public static ReviewsDTO entityToDTO(Reviews reviewsEntity){

        ReviewsDTO reviewsDTO = new ReviewsDTO();

        reviewsDTO.setId(reviewsEntity.getId());
        reviewsDTO.setRating(reviewsEntity.getRating());
        reviewsDTO.setTeamID(reviewsEntity.getTeams().getId());
        reviewsDTO.setUser_id(reviewsEntity.getUser_id());
        return reviewsDTO;
    }

    public static List<ReviewsDTO> listEntityToDTO(List<Reviews> reviewsEntity) {

        List<ReviewsDTO> reviewsDTO = new ArrayList<>();
        reviewsEntity.forEach(i -> {
            reviewsDTO.add(entityToDTO(i));


        });

        return reviewsDTO;
    }


}
