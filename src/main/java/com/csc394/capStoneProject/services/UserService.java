package com.csc394.capStoneProject.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
//    @Autowired
//    UserRepository userRepository;
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
////    public User saveUser(User user) {
////        if(user.getUserType().toString().isEmpty())
////            user.setUserType(TypeOfUser.USER);
////        return userRepository.save(user);
////    }
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
