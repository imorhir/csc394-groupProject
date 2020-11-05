package com.csc394.capStoneProject.dto;

import com.csc394.capStoneProject.entities.Goals;
import com.csc394.capStoneProject.entities.Status;
import com.csc394.capStoneProject.entities.Teams;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data

public class GoalsDTO {

    private Long id;

    private String description;

    private Integer grades;

    private Long teamId;

    private Status status;

    private Teams teams;










    public static GoalsDTO entityToDTO(Goals goalEntity){

        GoalsDTO goalsDTO = new GoalsDTO();
        if(goalEntity != null){
            goalsDTO.setId(goalEntity.getId());
            goalsDTO.setDescription(goalEntity.getDiscription());
            goalsDTO.setGrades(goalEntity.getGrades());
           goalsDTO.setTeamId(goalEntity.getTeams().getId());
           goalsDTO.setStatus(goalEntity.getStatus());


        }

        return goalsDTO;
    }
    public static List<GoalsDTO> listEntityToDTO(List<Goals> goalsEntity) {

        List<GoalsDTO> goalsDTO = new ArrayList<>();
        goalsEntity.forEach(i -> {
            goalsDTO.add(entityToDTO(i));


        });

        return goalsDTO;
    }
}
