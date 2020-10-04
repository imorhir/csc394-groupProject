package com.csc394.capStoneProject.team;

import com.csc394.capStoneProject.rating.Rating;
import com.csc394.capStoneProject.rating.RatingService;
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

    @GetMapping("/teams")
    public String getTeams(Model model) {
        Iterable<Team> teams = teamService.getAllTeams();
        model.addAttribute("teams", teams);

        return "team";
    }
}
