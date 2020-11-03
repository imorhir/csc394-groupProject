package com.csc394.capStoneProject.repositories;


import com.csc394.capStoneProject.entities.TypeOfUser;
import com.csc394.capStoneProject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);
    public List<User> findByTeamId(Long teamId);

}
