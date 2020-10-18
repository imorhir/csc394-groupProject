package com.csc394.capStoneProject.team;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name = "teams")
@Data
public class Team implements Serializable {
    private static final long serialVersionUID = 1L;

    // team id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long teamId;

    // student id
    @Column(name = "student_id")
    private Long studentId;

    // professor id
    @Column(name = "faculty_id")
    private Long facultyId;

    // team name
    @Column(name = "team_name")
    private String teamName;

    // set name
    public void setName (String name) {
        this.teamName = name;
    }
}
