package com.csc394.capStoneProject.controllers;

import com.csc394.capStoneProject.services.RoleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RoleController {

    @Autowired
    RoleServices roleServices;


}
