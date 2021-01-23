package com.project.moneymanager.controllers;

import com.project.moneymanager.models.*;
import com.project.moneymanager.services.MainService;
import com.project.moneymanager.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.text.DateFormat;
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

    @RequestMapping("/incomes/new")
    public String displayIncomeCreation(Principal principal, @ModelAttribute("income") Income myincome, Model model) {
//        if (principal.getName()!=null) {
        User user = userService.findUserByUsername(principal.getName());
        model.addAttribute("user", user);
        return "newIncome.jsp";
//        } else {
//            return "redirect:/";
//        }
    }

    @RequestMapping(value = "/incomes/new", method = RequestMethod.POST)
    public String createNewIncome(Principal principal, @Valid @ModelAttribute("income") Income myincome, BindingResult result, Model model, RedirectAttributes limitError) {
        User user = userService.findUserByUsername(principal.getName());
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
        User user = userService.findUserByUsername(principal.getName());
        model.addAttribute("currentUser", user);
        model.addAttribute("incomes", user.getIncomes());
        model.addAttribute("plans", user.getPlans());
        int total = 0;
        for (Income i : mainService.getAllIncomes()) {
            total += i.getAmount();
        }
        for (Expense i : mainService.findAllExpenses()) {
            total -= i.getAmount();
        }
        model.addAttribute("balance", total);

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
        if ((boolean) session.getAttribute("user")) {
            User user = (User) session.getAttribute("user");
            return user.getIncomes();
        }
        return null;
    }

    @RequestMapping("/plan/new")
    public String newplan(Principal principal, @ModelAttribute("plan") Plan plan, Model model) {
        User user = userService.findUserByUsername(principal.getName());
        model.addAttribute("user", user);

        return "addPlan.jsp";
    }

    @RequestMapping(value = "/plan/new", method = RequestMethod.POST)
    public String createplan(Principal principal, @Valid @ModelAttribute("plan") Plan plan, BindingResult result, Model model) {
        User user = userService.findUserByUsername(principal.getName());
        model.addAttribute("user", user);
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
        model.addAttribute("user", userService.findUserByUsername(principal.getName()));
        model.addAttribute("categories", mainService.findAllCategory());
        return "addExpense.jsp";
    }

    @RequestMapping(value = "/expense/new", method = RequestMethod.POST)
    public String createexpenses(Principal principal, @ModelAttribute("expense") Expense expense, RedirectAttributes rAttributes) {
        User user = userService.findUserByUsername(principal.getName());
        for (Plan plan : user.getPlans()) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd ");
            String today = df.format(Calendar.getInstance().getTime());
            Date tdy = expense.getCreatedAt();
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            String strDate = dateFormat.format(plan.getStart_datez());

            if (today.compareTo(strDate) > 0) {
                expense.setPlan(plan);
                mainService.addExpense(expense);
                System.out.println("expense added to plan");
                return "redirect:/incomes";
            }
        }
        rAttributes.addFlashAttribute("error", "there is no plan to add");
        return "redirect:/expense/new";
    }

    @RequestMapping("/history")
    public String hestory(Principal principal, Model model) {
        model.addAttribute("user", userService.findUserByUsername(principal.getName()));
        List<Plan> plans = userService.findUserByUsername(principal.getName()).getPlans();
        List<Income> incomes = userService.findUserByUsername(principal.getName()).getIncomes();
        List<Expense> expenses = null;
        for (Plan plan : plans) {
            if (expenses == null) {
                expenses = plan.getExpenses();
            } else {
                for (Expense i : plan.getExpenses())
                    expenses.add(i);
            }
        }
        model.addAttribute("username", principal.getName());
        model.addAttribute("incomes", incomes);
        model.addAttribute("expenses", expenses);
        return "history.jsp";
    }

    @RequestMapping("/category/new")
    public String newcategory(Principal principal, @ModelAttribute("category") Category category, Model model) {
        model.addAttribute("username", principal.getName());
        return "addcategory.jsp";
    }

    @RequestMapping(value = "/category/new", method = RequestMethod.POST)
    public String craeateategory(Principal principal, @Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addcategory.jsp";
        }
//        for(Category cat:mainService.findAllCategory()){
//            if(category.getName()==cat.getName()){
//                rAttributes.addFlashAttribute("error", "name already exists");
//                return "redirect:/category/new";
//            }
//        }
        mainService.createCategory(category);
        return "redirect:/incomes";
    }
}