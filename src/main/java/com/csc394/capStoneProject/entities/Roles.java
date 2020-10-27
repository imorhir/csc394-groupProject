package com.csc394.capStoneProject.entities;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
@Data

public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    // role_name
    @Column(name="role_name")
    private String roleName;

    // role_code
    @Column(name="role_code")
    private String roleCode;


//
    @OneToMany(targetEntity= User.class, mappedBy="role")
    private List<User> goals = new ArrayList<>();

    public String getRoleName () {
        return this.roleName;
    }

}
