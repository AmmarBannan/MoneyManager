package com.project.moneymanager.controllers;

import com.project.moneymanager.models.Income;
import com.project.moneymanager.models.Plan;
import com.project.moneymanager.models.User;
import com.project.moneymanager.services.MainService;
import com.project.moneymanager.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.*;
@Controller
public class MainController {
    private final MainService mainService;
    private final UserService userService;


    public MainController(MainService mainService, UserService userService) {
        this.mainService = mainService;
        this.userService = userService;
    }
//    @RequestMapping("/incomes/new")
//    public String newIncome(@ModelAttribute("income") Income income) {
//        mainService.createIncome(income);
//        return "newIncome.jsp";
//    }
//    @RequestMapping(value="/incomes", method= RequestMethod.POST)
//    public String create(@Valid @ModelAttribute("income") Income income, BindingResult result) {
//        if (result.hasErrors()) {
//            return "newIncome.jsp";
//        } else {
//            mainService.createIncome(income);
//            return "redirect:/incomes";
//        }
//    }

//    @RequestMapping("/incomes/new")
//    public String displayIncomeCreation(@ModelAttribute("income") Income myincome, Model model, HttpSession session) {
////        if (session.getAttribute("userId") != null) {
//            Long userId = (Long) session.getAttribute("userId");
//            User u = userService.findUserById(userId);
//            model.addAttribute("currentUser", u);
//            return "newIncome.jsp";
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
//            return "newIncome.jsp";
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
    //    @RequestMapping("/admin")
//    public String adminPage(Principal principal, Model model) {
//        String username = principal.getName();
//        model.addAttribute("currentUser", userService.findByUsername(username));
//        return "adminPage.jsp";
//    }


    //    @RequestMapping("/incomes/new")
//    public String newIncome(@ModelAttribute("income") Income income) {
//        return "newIncome.jsp";
//    }
//    @RequestMapping(value="/incomes", method= RequestMethod.POST)
//    public String create(@Valid @ModelAttribute("income") Income income, BindingResult result) {
//        if (result.hasErrors()) {
//            return "newIncome.jsp";
//        } else {
//            mainService.createIncome(income);
//            return "redirect:/incomes";
//        }
//    }
    @RequestMapping("/incomes/new")
    public String displayIncomeCreation(Principal principal,@ModelAttribute("income") Income myincome, Model model) {
//        if (principal.getName()!=null) {
            User user=userService.findUserByUsername(principal.getName());
            model.addAttribute("user",user);
            return "newIncome.jsp";
//        } else {
//            return "redirect:/";
//        }
    }
    @RequestMapping(value = "/incomes/new", method = RequestMethod.POST)
    public String createNewIncome(Principal principal,@Valid @ModelAttribute("income") Income myincome, BindingResult result, Model model, RedirectAttributes limitError) {
        User user=userService.findUserByUsername(principal.getName());
        model.addAttribute("user", user);
        if (result.hasErrors()) {
            return "newIncome.jsp";
        } else {
            Income newIncome = mainService.createIncome(myincome);
            newIncome.setUser(user);
            mainService.createIncome(newIncome);
            return "redirect:/incomes";
        }
    }

    @RequestMapping("/incomes")
    public String homepage(Principal principal, Model model) {
            User user=userService.findUserByUsername(principal.getName());
            model.addAttribute("plans", user.getPlans());
            model.addAttribute("currentUser", user);
            model.addAttribute("incomes", user.getIncomes());
            return "home.jsp";
    }
//    @RequestMapping("/incomes/{id}")
//    public String displayIncome(Model model, HttpSession session, @PathVariable("id") Long incomeId) {
//        Income income = mainService.findIncome(incomeId);
//        model.addAttribute("income", income);
//        Long userId = (Long) session.getAttribute("userId");
//        User u = userService.findUserById(userId);
//        model.addAttribute("currentUserId", u.getId());
//        return "showIncomes.jsp";
//    }

    @RequestMapping("/incomesd")
    public List<Income> displayincome(HttpSession session) {
        if((boolean) session.getAttribute("user")) {
            User user=(User) session.getAttribute("user");
            return user.getIncomes();
        }
        return null;
    }

    @RequestMapping("/plan/new")
    public String newplan(Principal principal, @ModelAttribute("plan") Plan plan, Model model) {
        User user=userService.findUserByUsername(principal.getName());
        model.addAttribute("user",user);

        return "addPlan.jsp";
    }
//    @RequestMapping("/plan/new")
//    public String createplan(Principal principal,@Valid@ModelAttribute("plan") Plan plan,BindingResult result, Model model) {
//        User user=userService.findUserByUsername(principal.getName());
//        model.addAttribute("user",user);
//        if (result.hasErrors()) {
//            return "addplan.jsp";
//        } else {
//            Plan oneplan = mainService.addPlan(plan);
//            oneplan.setUser(user);
//            mainService.createIncome(newIncome);
//            return "redirect:/incomes";
//        }
//    }
}
