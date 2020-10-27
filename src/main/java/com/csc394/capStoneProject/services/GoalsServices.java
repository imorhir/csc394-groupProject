package com.csc394.capStoneProject.services;

import com.csc394.capStoneProject.controllers.GoalsController;
import com.csc394.capStoneProject.entities.Goals;
import com.csc394.capStoneProject.repositories.GoalsRepository;
import com.csc394.capStoneProject.repositories.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalsServices {


    @Autowired
    GoalsRepository goalsRepository;
    @Autowired
    TeamsRepository teamsRepository;




    public List<Goals> findGoalByTeamId(Long teamId){
        return goalsRepository.findByTeams(teamsRepository.getOne(teamId));
    }

    public Goals grading(Long id, Integer grade){
        Goals updateGrade = goalsRepository.findGoalById(id);
        updateGrade.getGrades();
        updateGrade.setGrades(grade);
        return goalsRepository.save(updateGrade);
    }


}
