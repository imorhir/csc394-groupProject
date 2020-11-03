package com.csc394.capStoneProject.controllers;

import com.csc394.capStoneProject.dto.AssignGoalToTeam;
import com.csc394.capStoneProject.dto.AssignStdToTeamDTO;
import com.csc394.capStoneProject.dto.GoalsDTO;
import com.csc394.capStoneProject.dto.TeamsDTO;
import com.csc394.capStoneProject.entities.Goals;
import com.csc394.capStoneProject.entities.Teams;
import com.csc394.capStoneProject.services.GoalsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api/goals")
public class GoalsController {

@Autowired
GoalsServices goalsServices;



    @GetMapping("/teamGoal/{id}")
    public ResponseEntity <List<GoalsDTO>> getGoalByTeamId(@PathVariable(name ="id") Long teamId ){

        return ResponseEntity.ok()
                .body(GoalsDTO.listEntityToDTO(goalsServices.findGoalByTeamId(teamId)));
    }



    @RequestMapping(value="/grade", method = RequestMethod.PUT)

    public ResponseEntity<GoalsDTO> setGrade(@Valid @RequestBody Goals goals) {
        return ResponseEntity.ok().body(GoalsDTO.entityToDTO(goalsServices.grading(goals.getId(), goals.getGrades())));
    }


    @RequestMapping(value = "/faculty/addGoalsToTeam", method = RequestMethod.PUT)
    public ResponseEntity<String> addGoalsToTeam(
            @Valid @RequestBody AssignGoalToTeam assignGoalToTeam) {

        goalsServices.addGoalsToTeam(assignGoalToTeam);
        return ResponseEntity.ok().body("ok");
    }

    @RequestMapping(value="/updateStatus", method = RequestMethod.PUT)
    public ResponseEntity<GoalsDTO> updateGoalStatus(@Valid @RequestBody GoalsDTO goalsDTO){
        return ResponseEntity.ok().body(GoalsDTO.entityToDTO(goalsServices.changeStatus(goalsDTO.getId(),goalsDTO.getStatus())));
    }
}
