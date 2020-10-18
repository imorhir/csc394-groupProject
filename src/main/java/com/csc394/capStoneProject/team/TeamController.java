package com.csc394.capStoneProject.team;

import com.csc394.capStoneProject.rating.Rating;
import com.csc394.capStoneProject.rating.RatingService;
import com.csc394.capStoneProject.user.User;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TeamController {
    @Autowired
    TeamService teamService;

    private final TeamRepository teamRepo;

    TeamController(TeamRepository teamRepo) {
        this.teamRepo = teamRepo;
    }

    @GetMapping("/teams")
    public String getTeams(Model model) {
        Iterable<Team> teams = teamService.getAllTeams();
        model.addAttribute("teams", teams);

        return "team";
    }

    // get all teams
    @GetMapping("/teams")
    List<Team> all() {
        return teamRepo.findAll();
    }

    // add new team (member)
    @PostMapping("/teams")
    Team newTeam(@RequestBody Team newTeam) {
        return teamRepo.save(newTeam);
    }

    // delete team (and members)
    @DeleteMapping("/teams/{id}")
    void deleteTeam(@PathVariable Long id) {
        teamRepo.deleteById(id);
    }
}
