package com.csc394.capStoneProject.services;

import com.csc394.capStoneProject.dto.AssignStdToTeamDTO;
import com.csc394.capStoneProject.dto.UserDTO;
import com.csc394.capStoneProject.entities.Teams;
import com.csc394.capStoneProject.entities.TypeOfUser;
import com.csc394.capStoneProject.entities.User;
import com.csc394.capStoneProject.repositories.TeamsRepository;
import com.csc394.capStoneProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    TeamsRepository teamsRepository;



    public List<User> getUserStudentsByTeamId(Long teamId){

        return userRepository.findByTeamId(teamId);


    }

    public User addUser( User user) {


        return  userRepository.save(user);

    }

    public void  addUserToTeam(AssignStdToTeamDTO assignStdToTeamDTO){
        assignStdToTeamDTO.getListUserId().forEach(userId->{
            User user = userRepository.findById(userId).get();
            user.setTeamId(assignStdToTeamDTO.getTeamId());
            userRepository.save(user);
        });
    }





//
//    //
//
//    // TODO: delete unneeded
//
//    // get all users
    public List<User> getStudentUsers() {
        List<User> users = new ArrayList<>();
         userRepository.findAll().forEach(student->{
             if (student.getRoleId() == 3) {
                 users.add(student);
             }
         });

        return users;
    }
   

}
