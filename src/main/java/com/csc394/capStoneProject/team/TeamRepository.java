package com.csc394.capStoneProject.team;

import com.csc394.capStoneProject.rating.Rating;
import com.csc394.capStoneProject.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{
    List<Team> findByFaculty(Long facultyId);

    List<Team> findByStudent(Long studentId);
}
