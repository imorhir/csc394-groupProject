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

    // team_id
    @Column(name = "team_id")
    private Integer teamId;
    // user_id
    @Column(name = "user_id")
    private Integer user_id;

    // rating
    @Column(name = "rating")
    private Integer rating;

    @ManyToOne()
    @JoinColumn(name="team_id", referencedColumnName = "team_id" , insertable = false, updatable = false)
    private Teams teams;

//    @Column(name = "message")
//    private String message;

//    @Column(name = "reviewer_id")
//    private Long reviewerId;
//
//    @Column(name = "reviewee_id")
//    private Long revieweeId;

//    // set rate_val
//    public void setRating (Integer rateVal) {
//        this.rating = rateVal;
//    }
//
//    // set message
//    public void setMessage (String message) {
//        this.message = message;
//    }




}
