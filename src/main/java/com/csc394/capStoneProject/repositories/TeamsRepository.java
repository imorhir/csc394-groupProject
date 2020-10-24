package com.csc394.capStoneProject.repositories;

import com.csc394.capStoneProject.entities.Teams;
import com.csc394.capStoneProject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamsRepository extends JpaRepository<Teams, Long> {
    public List<Teams> findByProfessor(User professor);
}
