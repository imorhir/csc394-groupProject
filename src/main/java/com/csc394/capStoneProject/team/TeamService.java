package com.csc394.capStoneProject.team;

import com.csc394.capStoneProject.rating.Rating;
import com.csc394.capStoneProject.rating.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {
    @Autowired
    TeamRepository teamRepository;

    // get all ratings
    public List<Team> getAllTeams() {
        List<Team> teams = new ArrayList<Team>();
        teamRepository.findAll().forEach(e -> teams.add(e));
        return teams;
    }

    // save rating
    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }
}
