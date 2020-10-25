package com.csc394.capStoneProject.controllers;

import com.csc394.capStoneProject.dto.TeamsDTO;
import com.csc394.capStoneProject.entities.Teams;
import com.csc394.capStoneProject.services.TeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/teams")
public class TeamsController {

    @Autowired
    TeamsService teamsService;




     @GetMapping("/{id}")
     public ResponseEntity<Teams> getTeams(@PathVariable(name = "id") Long teamId) {

         Teams teams = teamsService.findById(teamId);
         return ResponseEntity.ok().body(teams);
     }
//
     @GetMapping("/professors/{id}")
    public ResponseEntity<List<TeamsDTO>> getTeamsByProfessor(@PathVariable(name ="id") Long professorId){

         return ResponseEntity.ok()
                 .body(TeamsDTO.listEntityToDTO(teamsService.findAllTeamByProfessorId(professorId)));
     }



}
