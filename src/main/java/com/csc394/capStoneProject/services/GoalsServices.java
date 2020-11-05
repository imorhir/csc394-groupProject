package com.csc394.capStoneProject.services;

import com.csc394.capStoneProject.dto.AssignGoalToTeam;
import com.csc394.capStoneProject.entities.Goals;
import com.csc394.capStoneProject.entities.Status;
import com.csc394.capStoneProject.repositories.GoalsRepository;
import com.csc394.capStoneProject.repositories.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoalsServices {


    @Autowired
    GoalsRepository goalsRepository;
    @Autowired
    TeamsRepository teamsRepository;



    public List<Goals> getAllGoals(){
        List<Goals> goals = new ArrayList<>();
        goalsRepository.findAll().forEach(goal -> {
            goals.add(goal);

        });
        return goals;

    }


    public List<Goals> findGoalByTeamId(Long teamId){
        return goalsRepository.findByTeams(teamsRepository.getOne(teamId));
    }

    public Goals grading(Long id, Integer grade){
        Goals updateGrade = goalsRepository.findGoalById(id);
        updateGrade.getGrades();
        updateGrade.setGrades(grade);
        return goalsRepository.save(updateGrade);
    }

    public void  addGoalsToTeam(AssignGoalToTeam assignGoalToTeam){

        assignGoalToTeam.getListGoalId().forEach(goals -> {
            //Teams teams = teamsRepository.findById(goals).get();
           Goals goal = goalsRepository.findById(goals).get();
           goal.setTeams(teamsRepository.findById(assignGoalToTeam.getTeamId()).get());
            goalsRepository.save(goal);
        });
    }

    public Goals changeStatus(Long id, Status status){
        Goals updateStatus = goalsRepository.findGoalById(id);
        updateStatus.getStatus();
        updateStatus.setStatus(status);
        return goalsRepository.save(updateStatus);
    }


}
