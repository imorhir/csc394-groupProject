package com.csc394.capStoneProject.dto;

import com.csc394.capStoneProject.entities.Goals;
import com.csc394.capStoneProject.entities.Teams;
import lombok.Data;

import java.util.List;


@Data
public class AssignGoalToTeam {


    private Long teamId;
    private List<Long> listGoalId;
}
