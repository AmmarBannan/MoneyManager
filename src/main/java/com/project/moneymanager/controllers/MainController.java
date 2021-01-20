package com.project.moneymanager.controllers;

import com.project.moneymanager.models.Income;
import com.project.moneymanager.models.User;
import com.project.moneymanager.services.MainService;
import com.project.moneymanager.services.UserService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;

public class MainController {
    private final MainService mainService;
    private final UserService userService;


    public MainController(MainService mainService, UserService userService) {
        this.mainService = mainService;
        this.userService = userService;
    }
    @RequestMapping("/incomes/new")
    public String newIncome(@ModelAttribute("income") Income income) {
        return "newIncome.jsp";
    }
    @RequestMapping(value="/incomes", method= RequestMethod.POST)
    public String create(@Valid @ModelAttribute("income") Income income, BindingResult result) {
        if (result.hasErrors()) {
            return "newIncome.jsp";
        } else {
            mainService.createIncome(income);
            return "redirect:/incomes";
        }
    }

//    @RequestMapping("/incomes/new")
//    public String displayIncomeCreation(@ModelAttribute("income") Income myincome, Model model, HttpSession session) {
////        if (session.getAttribute("userId") != null) {
//            Long userId = (Long) session.getAttribute("userId");
//            User u = userService.findUserById(userId);
//            model.addAttribute("currentUser", u);
//            return "login.jsp";
////        } else {
////            return "redirect:/";
////        }
//    }
//    @RequestMapping(value = "/incomes/new", method = RequestMethod.POST)
//    public String createNewIncome(@Valid @ModelAttribute("income") Income myincome, BindingResult result, HttpSession session,
//                                  Model model, RedirectAttributes limitError) {
//        Long userId = (Long) session.getAttribute("userId");
//        User u = userService.findUserById(userId);
//        model.addAttribute("user", u);
//        if (result.hasErrors()) {
//            return "login.jsp";
//        } else {
//            Income newIncome = mainService.createIncome(myincome);
//            newIncome.setUser(u);
//            mainService.updateIncome(newIncome);
//
//            return "redirect:/incomes";
//        }
//    }
//
//    @RequestMapping("/incomes")
//    public String homepage(HttpSession session, Model model) {
//     if (session.getAttribute("userId") != null) {
//            Long userId = (Long) session.getAttribute("userId");
//            User u = userService.findUserById(userId);
//            model.addAttribute("user", u);
//            List<Income> incomeList = mainService.getAllIncomes();
//            model.addAttribute("incomes", incomeList);
//            return "home.jsp";
//        } else {
//            return "redirect:/";
//        }
//    }
//    @RequestMapping("/incomes/{id}")
//    public String displayIncome(Model model, HttpSession session, @PathVariable("id") Long incomeId) {
//        Income income = mainService.findIncome(incomeId);
//        model.addAttribute("income", income);
//        Long userId = (Long) session.getAttribute("userId");
//        User u = userService.findUserById(userId);
//        model.addAttribute("currentUserId", u.getId());
//        return "showIncomes.jsp";
//    }
//
//    @RequestMapping("/incomes")
//    public List<Income> displayincome(HttpSession session) {
//        if((boolean) session.getAttribute("user")) {
//            User user=(User) session.getAttribute("user");
//            return user.getIncomes();
//        }
//        return null;
//    }

}
