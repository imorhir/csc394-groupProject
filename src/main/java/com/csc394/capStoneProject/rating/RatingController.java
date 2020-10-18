package com.csc394.capStoneProject.rating;

import com.csc394.capStoneProject.rating.RatingService;
import com.csc394.capStoneProject.team.Team;
import com.csc394.capStoneProject.team.TeamRepository;
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

    private final RatingRepository ratingRepo;

    RatingController(RatingRepository ratingRepo) {
        this.ratingRepo = ratingRepo;
    }

    @GetMapping("/ratings")
    public String getRatings(Model model) {
        Iterable<Rating> ratings = ratingService.getAllRatings();
        model.addAttribute("ratings", ratings);

        return "rating";
    }

    // get all ratings
    @GetMapping("/ratings")
    List<Rating> all() {
        return ratingRepo.findAll();
    }

    // add new rating
    @PostMapping("/ratings")
    Rating newRating(@RequestBody Rating newRating) {
        return ratingRepo.save(newRating);
    }

    // delete rating
    @DeleteMapping("/ratings/{id}")
    void deleteRating(@PathVariable Long id) {
        ratingRepo.deleteById(id);
    }
}
