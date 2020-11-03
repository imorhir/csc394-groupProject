package com.csc394.capStoneProject.services;

import com.csc394.capStoneProject.entities.Teams;
import com.csc394.capStoneProject.entities.User;
import com.csc394.capStoneProject.repositories.TeamsRepository;
import com.csc394.capStoneProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamsService {

    @Autowired
    TeamsRepository teamsRepository;
    @Autowired
    UserRepository userRepository;
    //   get all team by id.

    public Teams findById(Long teamById) {
        return teamsRepository.findById(teamById).get();
    }


    public List<Teams> findAllTeamByProfessorId(Long professorId) {


        return teamsRepository.findByProfessor(userRepository.getOne(professorId));

    }


    public Teams addTeam(Teams team) {


        return  teamsRepository.save(team);
    }




}




//    public List<Teams> getAllTeamsById() {
//        List<User> users = new ArrayList<User>();
//        userRepository.findAll().forEach(users::add);
//        return users;
//    }


