package com.csc394.capStoneProject.rating;

import com.csc394.capStoneProject.rating.RatingService;
import com.csc394.capStoneProject.user.User;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RatingController {

    @Autowired
    RatingService ratingService;

    @GetMapping("/ratings")
    public String getRatings(Model model) {
        Iterable<Rating> ratings = ratingService.getAllRatings();
        model.addAttribute("ratings", ratings);

        return "rating";
    }
}
