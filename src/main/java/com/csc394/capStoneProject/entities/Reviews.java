package com.csc394.capStoneProject.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="reviews")
@Data
public class Reviews implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    // user_id
    @Column(name = "user_id")
    private Integer userId;

    // rating
    @Column(name = "rating")
    private Integer rating;

    @ManyToOne()
    @JoinColumn(name="team_id", referencedColumnName = "team_id", insertable = true, updatable = true)
    private Teams teams;
    
}
