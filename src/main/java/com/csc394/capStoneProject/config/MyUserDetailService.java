package com.csc394.capStoneProject.config;

//import com.csc394.capStoneProject.config.MyUserDetails;
import com.csc394.capStoneProject.dto.UserDTO;
import com.csc394.capStoneProject.entities.User;
import com.csc394.capStoneProject.repositories.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Data
@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        User  user = userRepository.findByUserName(userName);
////        user.orElseThrow(()-> new  UsernameNotFoundException("not found: " + userName ));
////         return user.map(MyUserDetails::new).get();
//        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
//    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userDTO = userRepository.findByUserName(username);
        return new org.springframework.security.core.userdetails.User(userDTO.getUserName(), userDTO.getPassword(), new ArrayList<>());
    }
}
