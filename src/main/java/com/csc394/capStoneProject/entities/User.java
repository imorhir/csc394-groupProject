package com.csc394.capStoneProject.entities;

import java.io.Serializable;

import javax.persistence.*;


import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    // user id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    // first name
    @Column(name = "first_name")
    private String firstName;

    // last name
    @Column(name = "last_name")
    private String lastName;

//     roleType
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "user_email")
    private String userEmail;

    // userName
    @Column(name= "user_name")
    private String userName;

    // passWord
    @Column(name = "pass_word")
    private String password;
    // teamId
    @Column(name = "team_id")
    private Long teamId;

    @ManyToOne()
    @JoinColumn(name="team_id", referencedColumnName = "team_id", insertable = false, updatable = false )
    private Teams teams;

    @ManyToOne()
    @JoinColumn(name="role_id", referencedColumnName = "role_id" , insertable = false, updatable = false)
    private Roles role;

//    public String getUserName () {
//        return this.userName;
//    }
//
//    public String getPassword () {
//        return this.password;
//    }
//
//    public Roles getRole () {
//        return this.role;
//    }
//
//    public void setTeamId (Long teamId) {
//        this.teamId = teamId;
//    }
}


