package com.project.moneymanager.controllers;

import com.project.moneymanager.models.Income;
import com.project.moneymanager.models.User;
import com.project.moneymanager.services.MainService;
import com.project.moneymanager.services.UserService;
import com.project.moneymanager.validator.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;
    private UserValidator userValidator;
    private MainService mainService;



    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @RequestMapping( "/index")
    public String index() {
        return "index.jsp";
    }

    @RequestMapping("/registration")
    public String registerForm(@Valid @ModelAttribute("user") User user) {
        return "registration.jsp";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Your username and password is invalid!!, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "You have been logged out successfully!");
        }

        return "login.jsp";
    }

    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "registration.jsp";
        }
        userService.saveWithUserRole(user);
        return "redirect:/login";
    }

<<<<<<< HEAD
//    @RequestMapping("/admin")
//    public String adminPage(Principal principal, Model model) {
//        String username = principal.getName();
//        model.addAttribute("currentUser", userService.findByUsername(username));
//        return "adminPage.jsp";
//    }

    @RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        return "Main.jsp";
    }
=======

>>>>>>> b59787f4103aa518a01d69b83b5af0496316177d




}
