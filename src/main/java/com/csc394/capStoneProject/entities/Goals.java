package com.csc394.capStoneProject.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "goals")
@Data
public class Goals implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_id")
    private Long id;


    @Column(name = "goal_discription")
    private String discription;

    @Column(name="grades")
    private Integer grades;

//
    @ManyToOne()
    @JoinColumn(name="team_id", referencedColumnName = "team_id",  insertable = false, updatable = false)
    private Teams teams;

    public Integer getGrades () {
        return this.grades;
    }

    public Long getId () {
        return this.id;
    }

    public void setGrades (Integer grades) {
        this.grades = grades;
    }

}
