package com.csc394.capStoneProject.dto;

import com.csc394.capStoneProject.entities.Teams;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data

public class TeamsDTO {


    private Long id;


    private Integer userId;


    private String teamName;

    private Integer numberOfMenbers;

    public static TeamsDTO entityToDTO(Teams teamsEntity){

        TeamsDTO teamsDTO = new TeamsDTO();
        if(teamsEntity!=null) {
            teamsDTO.setId(teamsEntity.getId());
            teamsDTO.setUserId(teamsEntity.getUserId());
            teamsDTO.setTeamName(teamsEntity.getTeamName());
        }
        return teamsDTO;
    }
    public static List<TeamsDTO> listEntityToDTO(List<Teams> teamsEntity){
        List<TeamsDTO> teamsDTO = new ArrayList<>();
         teamsEntity.forEach(i-> teamsDTO.add(entityToDTO(i)));
         return teamsDTO;
    }





}
