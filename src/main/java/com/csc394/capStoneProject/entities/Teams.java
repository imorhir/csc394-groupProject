package com.csc394.capStoneProject.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
@Data
public class Teams implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;
    // user_id
    @Column(name="user_id")
    private Integer userId;
    // team_name
    @Column(name="team_name")
    private String teamName;
//
//    public Long getId () {
//        return this.id;
//    }
//
//    public Integer getUserId () {
//        return this.userId;
//    }
//
//    public String getTeamName () {
//        return this.teamName;
//    }
//
//    public void setTeamName (String name) {
//        this.teamName = name;
//    }

    @OneToMany(cascade = CascadeType.ALL, targetEntity=Goals.class, mappedBy="teams")
    private List<Goals> goals = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, targetEntity=Reviews.class, mappedBy="teams")
    private List<Reviews> reviews = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User professor;
}
