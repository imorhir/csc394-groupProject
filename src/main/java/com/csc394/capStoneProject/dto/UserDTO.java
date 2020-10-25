package com.csc394.capStoneProject.dto;

import com.csc394.capStoneProject.entities.Teams;
import com.csc394.capStoneProject.entities.User;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data
public class UserDTO {

    private Long id;
    private String userEmail;

    private String firstName;


    private String lastName;


    private Long roleId;


    private String userName;


    private String password;

    private Long teamId;


    public static UserDTO entityToDTO(User userEntity){
        UserDTO userDTO = new UserDTO();
        if(userEntity!=null) {
            userDTO.setId(userEntity.getId());
            userDTO.setFirstName(userEntity.getFirstName());
            userDTO.setUserEmail(userEntity.getUserEmail());
            userDTO.setLastName(userEntity.getLastName());
            userDTO.setUserName(userEntity.getUserName());
            userDTO.setPassword(userEntity.getPassword());
            userDTO.setTeamId(userEntity.getTeamId());
            userDTO.setRoleId(userEntity.getRoleId());
        }
        return userDTO;
    }
    public static User dtoToEntity(UserDTO userdto){
        User userEntity = new User();

        if(userdto!=null) {
            userEntity.setId(userdto.getId());
            userEntity.setFirstName(userdto.getFirstName());
            userEntity.setFirstName(userdto.getUserEmail());
            userEntity.setLastName(userdto.getLastName());
            userEntity.setUserName(userdto.getUserName());
            userEntity.setPassword(userdto.getPassword());
            userEntity.setTeamId(userdto.getTeamId());
            userEntity.setRoleId(userdto.getRoleId());
        }
        return userEntity;
    }

    public static List<UserDTO> listEntityToDTO(List<User> userEntity){
        List<UserDTO> userDTO = new ArrayList<>();
        userEntity.forEach(i-> userDTO.add(entityToDTO(i)));
        return userDTO;
    }

    public static List<User> listDTOToEntity(List<UserDTO> userdto){
        List<User> userEntity = new ArrayList<>();
        userdto.forEach(i-> userEntity.add(dtoToEntity(i)));
        return userEntity;
    }
}
