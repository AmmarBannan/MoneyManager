package com.project.moneymanager.controllers;

import com.project.moneymanager.models.Expense;
import com.project.moneymanager.models.Income;
import com.project.moneymanager.models.Plan;
import com.project.moneymanager.models.User;
import com.project.moneymanager.services.MainService;
import com.project.moneymanager.services.UserService;
import org.hibernate.validator.constraints.Currency;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.text.SimpleDateFormat;
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
            model.addAttribute("currentUser", user);
        model.addAttribute("incomes", user.getIncomes());
        model.addAttribute("plans", user.getPlans());
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

 @RequestMapping(value="/plan/new", method = RequestMethod.POST)
 public String createplan(Principal principal,@Valid@ModelAttribute("plan") Plan plan,BindingResult result, Model model) {
        User user=userService.findUserByUsername(principal.getName());
        model.addAttribute("user",user);
        if (result.hasErrors()) {
            return "addPlan.jsp";
        } else {
            plan.setUser(user);
            Plan oneplan = mainService.addPlan(plan);
            return "redirect:/incomes";
        }
    }

//    @RequestMapping("/expense/new")
//    public String newexpenses(Principal principal, Model model) {
//        model.addAttribute("user",userService.findUserByUsername(principal.getName()));
//        return "addExpense.jsp";
//    }
//
//    @RequestMapping(value="/expense/new", method = RequestMethod.POST)
//    public String createexpenses(Principal principal,@RequestParam(value="amount") int amount,
//                                 @RequestParam(value="description") String description,
//                                 @RequestParam(value="date") Date date,Model model,
//                                 RedirectAttributes rAttributes) {
//            User user = userService.findUserByUsername(principal.getName());
//            Plan plan = mainService.findplanbydate(user, date);
//
//            Expense expense = new Expense(amount, description, date, plan);
//            mainService.addExpense(expense);
//
//            return "redirect:/incomes";
//
//    }
    @RequestMapping("/expense/new")
    public String newexpenses(Principal principal, @ModelAttribute("expense") Expense expense, Model model) {
        model.addAttribute("user",userService.findUserByUsername(principal.getName()));
        return "addExpense.jsp";
    }

    @RequestMapping(value="/expense/new", method = RequestMethod.POST)
    public String createexpenses(Principal principal,@ModelAttribute("expense") Expense expense) {
        User user = userService.findUserByUsername(principal.getName());
//        Plan plan = mainService.findplanbydate(user, expense.getDate());
        Plan plan=null;
        for(Plan pland:user.getPlans()) {
            Date currentDate = new Date();
            if (currentDate.compareTo(pland.getStart_datez())>0) {
                plan=pland;
            }
        }
        if(plan==null){return "redirect:/expense/new";}
        expense.setPlan(plan);
        mainService.addExpense(expense);
        return "redirect:/incomes";

    }
    @RequestMapping("/hestory")
    public String hestory(Principal principal, Model model) {
        model.addAttribute("user", userService.findUserByUsername(principal.getName()));
        List<Plan> plans = userService.findUserByUsername(principal.getName()).getPlans();
        List<Income> incomes = userService.findUserByUsername(principal.getName()).getIncomes();
        List<Expense> expenses=null;
        for (Plan plan : plans) {
            if(expenses.isEmpty()) {
                List<Expense> exps = plan.getExpenses();
            }
            else{
                for(Expense i:plan.getExpenses())
                    expenses.add(i);
            }
        }
        model.addAttribute("user",userService.findUserByUsername(principal.getName()).getIncomes());
        model.addAttribute("incomes",incomes);
        model.addAttribute("expenses",expenses);
        return "hestory.jsp";
    }

}
