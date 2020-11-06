package com.csc394.capStoneProject.controllers;


import com.csc394.capStoneProject.dto.AuthRequestDTO;
import com.csc394.capStoneProject.dto.UserDTO;
import com.csc394.capStoneProject.entities.User;
import com.csc394.capStoneProject.repositories.UserRepository;
import com.csc394.capStoneProject.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController

public class WelcomeController {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String welcome(){
        return  "welcome to my security";
    }
    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequestDTO userDTO) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDTO.getUserName(),userDTO.getPassword())
            );
        }catch (Exception e){
            throw new Exception("Invalid UserName or Password");
        }
       return  jwtUtil.generateToken(userDTO.getUserName());

    }

}
