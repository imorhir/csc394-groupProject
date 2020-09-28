package com.csc394.capStoneProject.user;


import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    // login
    @GetMapping({"/", "/login"})
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
    // 'admin@admin.com', 'ADMIN'
    @PostMapping("/login")
    public String succ(@ModelAttribute User user) {
        if(user.getEmail().isEmpty() || user.getPassword().isEmpty())
            return "redirect:/login";

        // User u = userService.getUserEmail(user.getEmail());

        // if(u.getId().equals(null))
        //     return "redirect:/login";

        // System.out.println("################");
        // System.out.println(user.toString());
        // System.out.println(u.toString());
        // System.out.println("################");

        return "redirect:/main";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        Iterable<User> users = userService.getAllUsers();
        model.addAttribute("users", users);

        return "user";
    }



    // create user
    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("user", new User());

        return "signup";
    }

    @PostMapping("/signup")
    public String createUser(@ModelAttribute User user) {
        if (user.getFirstName().isEmpty())
            return "signup";
        if (user.getLastName().isEmpty())
            return "signup";

        if (user.getEmail().isEmpty())
            return "signup";
        if (user.getPassword().isEmpty())
            return "signup";

        userService.saveUser(user);

        return "redirect:/main";
    }

    @GetMapping("/main")
    public String mainAdmin(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "main";
    }




    @GetMapping("/users/create")
    public String createUserAdmin(Model model) {
        model.addAttribute("user", new User());

        return "create-user";
    }

    @PostMapping("/users/create")
    public String createUserPost(@ModelAttribute User user) {
        if (user.getFirstName().isEmpty())
            return "create-user";
        if (user.getLastName().isEmpty())
            return "create-user";

        if (user.getEmail().isEmpty())
            return "create-user";
        if (user.getPassword().isEmpty())
            return "create-user";

        userService.saveUser(user);

        return "redirect:/main";
    }


}





