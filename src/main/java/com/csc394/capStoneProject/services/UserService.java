package com.csc394.capStoneProject.services;

import com.csc394.capStoneProject.dto.AssignStdToTeamDTO;
import com.csc394.capStoneProject.entities.Teams;
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
//    public List<User> getAllUsers() {
//        List<User> users = new ArrayList<User>();
//        userRepository.findAll().forEach(e -> users.add(e));
//        return users;
//    }
    // getAll Users
//
//    // get one user (by id)
////  public User getUser(Long id) {
////        return userRepository.findById(id).get();
////    }
//
//    // get by email
////    public User getUserEmail(String email) {
////        return userRepository.findByEmail(email);
////    }
//
////    // save user
//    public User saveUser(User user) {
//         user.getRole().toString().isEmpty();
//        if(user.getUserType().toString().isEmpty())
//            user.setUserType(TypeOfUser.USER);
//        return userRepository.save(user);
//    }
//
////    public User updateUser(Long userID, User user) {
////        user.setId(userID);
////
////        user.setAddress(userRepository.findById(userID).get().getAddress());
////
////        return userRepository.save(user);
////    }
//
//    // delete user
////    public void deleteUser(User user) {
////        userRepository.delete(user);
////    }
////
////    public List<User> findUserByType(TypeOfUser typeOfUser) {
////        return userRepository.findByUserType(typeOfUser);
////    }

}
