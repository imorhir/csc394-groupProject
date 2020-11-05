package com.csc394.capStoneProject.controllers;


import com.csc394.capStoneProject.dto.AssignStdToTeamDTO;
import com.csc394.capStoneProject.dto.TeamsDTO;
import com.csc394.capStoneProject.dto.UserDTO;
import com.csc394.capStoneProject.entities.Teams;
import com.csc394.capStoneProject.entities.User;
import com.csc394.capStoneProject.repositories.TeamsRepository;
import com.csc394.capStoneProject.repositories.UserRepository;
import com.csc394.capStoneProject.services.TeamsService;
import com.csc394.capStoneProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    TeamsRepository teamsRepository;
    @Autowired
    UserRepository userRepository;



   @GetMapping("/teams/{id}")
   public ResponseEntity<List<UserDTO>> listStudentsInTeam(@PathVariable(name = "id") Long teamId){

       return  ResponseEntity.ok().body(UserDTO.listEntityToDTO(userService.getUserStudentsByTeamId(teamId)));
   }

    @RequestMapping(value="/addUser", method = RequestMethod.POST )
    public ResponseEntity<UserDTO> addUser(
            @Valid @RequestBody UserDTO userdto) {
        return ResponseEntity.ok().body(UserDTO.entityToDTO(userService.addUser(UserDTO.dtoToEntity(userdto))));
    }

    @RequestMapping(value = "/faculty/addUserToTeam", method = RequestMethod.PUT)
    public ResponseEntity<String> addUserToTeam(
           @Valid @RequestBody AssignStdToTeamDTO assignStdToTeamDTO) {
        userService.addUserToTeam(assignStdToTeamDTO);
        return ResponseEntity.ok().body("ok");
    }

    @RequestMapping(value = "/allStudentUsers", method = RequestMethod.GET)
    public ResponseEntity <List<UserDTO>> getAllStudents(){
       return ResponseEntity.ok().body(UserDTO.listEntityToDTO(userService.getStudentUsers()));
    }

}





