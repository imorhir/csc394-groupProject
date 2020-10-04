package com.csc394.capStoneProject.rating;

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
@Table(name = "ratings")
@Data
public class Rating implements Serializable {
    private static final long serialVersionUID = 1L;

    // rating id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private Long ratingId;

    // rate value
    @Column(name = "rate_val")
    private Short rateVal;

    // message
    @Column(name = "message")
    private String message;

    // rater id
    @Column(name = "rater_id")
    private Long raterId;

    // ratee id
    @Column(name = "ratee_id")
    private Long rateeId;

    // timestamp
    @Column(name = "timestamp")
    private Date timestamp;
}