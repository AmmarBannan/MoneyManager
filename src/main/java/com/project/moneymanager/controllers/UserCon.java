package com.project.moneymanager.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.moneymanager.models.User;
import com.project.moneymanager.services.UserService;
import com.project.moneymanager.validator.UserValidator;



public class UserCon {
	final private UserService userService;
	final private UserValidator userValidator;
	
	
	public UserCon(UserService userService, UserValidator userValidator) {
		super();
		this.userService = userService;
		this.userValidator = userValidator;
	}

	@RequestMapping("/")
    public String start (@ModelAttribute("user") User user) {
        return "start.jsp";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("user") User user, BindingResult result,
                           HttpSession session) {
        userValidator.validate(user, result);

        if (result.hasErrors()) {
            return "start.jsp";
        }
        else {
            userService.registerUser(user);
            session.setAttribute("id", user.getId());
            return "redirect:/home";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password, HttpSession session, RedirectAttributes r) {
        boolean success = userService.authenticateUser(email, password);

        if (email.length() < 1) {
            r.addFlashAttribute("error", "Email field cannot be blank.");
            return "redirect:/";
        }
        else if (password.length() < 1) {
            r.addFlashAttribute("error", "Please enter your password.");
            return "redirect:/";
        }
        else if (!success) {
            r.addFlashAttribute("error", "Email and password do not match.");
            return "redirect:/";
        }
        else {
            User user = userService.getUserByEmail(email);
            Long id = user.getId();
            session.setAttribute("id", id);
            return "redirect:/home";
        }
    }

    @RequestMapping("/home")
    public String home (HttpSession session, Model model) {
        Long id = (Long) session.getAttribute("id");
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "home.jsp";
    }

    @RequestMapping("/logout")
    public String logout (HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
