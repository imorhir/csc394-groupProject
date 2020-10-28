package com.csc394.capStoneProject.repositories;

import com.csc394.capStoneProject.entities.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews, Long> {

//    List<Reviews> findByReviewerId(Long reviewerId);
//
//    List<Reviews> findByRevieweeId(Long revieweeId);
}
