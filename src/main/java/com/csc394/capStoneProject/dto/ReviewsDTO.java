package com.csc394.capStoneProject.dto;

import com.csc394.capStoneProject.entities.Goals;
import com.csc394.capStoneProject.entities.Reviews;
import com.csc394.capStoneProject.entities.Teams;
import com.csc394.capStoneProject.entities.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data

public class ReviewsDTO {

    private Long id;
    private Long teamId;
    private Integer userId;
    private Integer rating;
    private Teams teams;
//    private String message;
//    private Long reviewerId;
//    private Long revieweeId;


    public static ReviewsDTO entityToDTO(Reviews reviewsEntity){

        ReviewsDTO reviewsDTO = new ReviewsDTO();
        if(reviewsEntity != null){
            reviewsDTO.setId(reviewsEntity.getId());
            reviewsDTO.setTeamId(reviewsEntity.getTeams().getId());
            reviewsDTO.setUserId(reviewsEntity.getUserId());
            reviewsDTO.setRating(reviewsEntity.getRating());
 //           reviewsDTO.setTeams(reviewsEntity.getTeams().getId());
        }

        return reviewsDTO;
    }
//
    public static Reviews dtoToEntity(ReviewsDTO reviewsDto){
        Reviews reviewsEntity = new Reviews();

        if(reviewsDto!=null) {
            reviewsEntity.setId(reviewsDto.getId());
            reviewsEntity.setUserId(reviewsDto.getUserId());
            reviewsEntity.setRating(reviewsDto.getRating());
            reviewsEntity.setTeams(reviewsDto.getTeams());
        }
        return reviewsEntity;
    }

    public static List<ReviewsDTO> listEntityToDTO(List<Reviews> reviewsEntity){
        List<ReviewsDTO> reviewsDTO = new ArrayList<>();
        reviewsEntity.forEach(i-> reviewsDTO.add(entityToDTO(i)));
        return reviewsDTO;
    }

    public static List<Reviews> listDTOToEntity(List<ReviewsDTO> reviewsDto){
        List<Reviews> reviewsEntity = new ArrayList<>();
        reviewsDto.forEach(i-> reviewsEntity.add(dtoToEntity(i)));
        return reviewsEntity;
    }

}
