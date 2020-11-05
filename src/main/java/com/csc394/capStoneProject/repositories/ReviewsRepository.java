package com.csc394.capStoneProject.repositories;

import com.csc394.capStoneProject.entities.Reviews;
import com.csc394.capStoneProject.entities.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews, Long> {
    public List<Reviews> findByTeams(Teams team);
}
