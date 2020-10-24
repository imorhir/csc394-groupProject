package com.csc394.capStoneProject.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {
    @Autowired
    TeamRepository teamRepository;

    // get all teams
    public List<Team> getAllTeams() {
        List<Team> teams = new ArrayList<Team>();
        teamRepository.findAll().forEach(e -> teams.add(e));
        return teams;
    }

    // save team
    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    // get team by id
    public Team getTeamById(Long id) {
        return teamRepository.findById(id).get();
    }

    // get teams by faculty
    public List<Team> getTeamByFaculty(Long id) {
        List<Team> teams = new ArrayList<Team>();
        teamRepository.findByFaculty(id).forEach(e -> teams.add(e));
        return teams;
    }

    // get teams by student
    public List<Team> getTeamByStudent(Long id) {
        List<Team> teams = new ArrayList<Team>();
        teamRepository.findByStudent(id).forEach(e -> teams.add(e));
        return teams;
    }

    // update name of team
    public Team updateTeamName(Team team, String teamName) {
        team.setName(teamName);
        return teamRepository.save(team);
    }

    // delete team (member)
    public void deleteTeamMember(Team team) {
        teamRepository.delete(team);
    }
}
