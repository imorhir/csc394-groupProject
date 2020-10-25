package com.csc394.capStoneProject.repositories;

import com.csc394.capStoneProject.entities.Goals;
import com.csc394.capStoneProject.entities.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GoalsRepository extends JpaRepository <Goals, Long> {

  public List<Goals> findByTeams(Teams team);
  public Goals findGoalById(Long goalId);
}
