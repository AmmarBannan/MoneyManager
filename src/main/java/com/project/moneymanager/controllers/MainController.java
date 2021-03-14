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
        User user = userService.findUserByUsername(principal.getName());
        model.addAttribute("user", user);

        return "newIncome.jsp";
    }

    @RequestMapping(value = "/incomes/new", method = RequestMethod.POST)
    public String createNewIncome(Principal principal, @Valid @ModelAttribute("income") Income myincome, BindingResult result, Model model) {
        User user = userService.findUserByUsername(principal.getName());
        if (result.hasErrors()) {
            return "newIncome.jsp";
        } else {
            mainService.addIncome(user,myincome);
            return "redirect:/incomes";
        }
    }

    @RequestMapping("/incomes")
    public String homepage(Principal principal, Model model,@ModelAttribute("note") Note note, @ModelAttribute("category") Category category,BindingResult result) {
        User user = userService.findUserByUsername(principal.getName());
        Balance balance=null;
        if(user.getBalances().size()<1){
            balance=new Balance(user,0);
        }
        else {
            balance = mainService.getlastbalance(user);
        }
        /////////////////////////////////
        Integer[] values=new Integer[user.getBalances().size()];


        int[] dates=new int[user.getBalances().size()];
        int j=0;
        for(Balance bal:user.getBalances()){
            values[j]=bal.getVal();
            dates[j]=j;
            j++;
        }

        ///////////////////////////////
        String[] categories=new String[user.getCategories().size()];
        int[] persent=new int[user.getCategories().size()];
        int i=0;
        for(Category cat:user.getCategories()){
            categories[i]=cat.getName();
            for(int tt:persent){
                persent[i]=0;
            }
            for(Expense exp:cat.getExpenses()){
                persent[i]=exp.getAmount();
            }
            i++;
        }


//        System.out.println(dates);
//        System.out.println();
        System.out.println("categories///////////////////////////////////");
//        for(int d=0;d<categories.length;d++){
//            System.out.println(categories[i]);
//            System.out.println(persent[i]);
//        }
        List<Balance> balances = user.getBalances();
        model.addAttribute("balances", balances);

        model.addAttribute("currentUser", user);
        model.addAttribute("incomes", user.getIncomes());
        model.addAttribute("plans", user.getPlans());


        model.addAttribute("notes",user.getNotes());
        model.addAttribute("balance",balance.getVal() );

        model.addAttribute("dates",dates);
        model.addAttribute("values",values);

        model.addAttribute("categories",categories);
        model.addAttribute("persent",persent);

        return "home.jsp";

    }

    @RequestMapping(value = "/newnote",method = RequestMethod.POST)
    public String newnote(Principal principal,@Valid@ModelAttribute("note") Note note,BindingResult result) {
        if(result.hasErrors()){
            return "redirect:/incomes";
        }
        User user = userService.findUserByUsername(principal.getName());
        mainService.createnote(user,note);
        return "redirect:/incomes";
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
    public String createexpenses(Principal principal, @Valid@ModelAttribute("expense") Expense expense, RedirectAttributes rAttributes) {
        User user = userService.findUserByUsername(principal.getName());
        for (Plan plan : user.getPlans()) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd ");
            String today = df.format(Calendar.getInstance().getTime());
//            Date tdy = expense.getCreatedAt();
//            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            String strDate = dateFormat.format(plan.getStart_datez());

            if (today.compareTo(strDate) > 0) {
                expense.setPlan(plan);
                mainService.addExpense(user,expense);
                System.out.println("expense added to plan");
                return "redirect:/incomes";
            }
        }
        if(expense.getAmount()>expense.getPlan().getLimitz()) {
            rAttributes.addFlashAttribute("amounterrror","your expense have  exceeded your plan");
            return "redirect:/incomes";
        }
        if(expense.getAmount()>expense.getPlan().getLimitz()) {
            rAttributes.addFlashAttribute("amounterrror","your expense have  exceeded your plan");
            return "redirect:/incomes";
        }

        mainService.addExpense(user,expense);
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


    @RequestMapping(value = "/category/new", method = RequestMethod.POST)
    public String craeateategory(Principal principal, @Valid @ModelAttribute("category") Category category, BindingResult result,
                                 Model model,RedirectAttributes rAttributes) {
        User user = userService.findUserByUsername(principal.getName());
        if (result.hasErrors()) {
            return "addcategory.jsp";
        }
        for(Category cat:mainService.findAllCategory()){
            if(category.getName()==cat.getName()){
                rAttributes.addFlashAttribute("error", "name already exists");
                return "redirect:/category/new";
            }
        }
        category.setUser(user);
        mainService.createCategory(category);
        return "redirect:/incomes";
    }
    @RequestMapping("/user")
    public String edituser(Principal principal, @ModelAttribute("user") User user, Model model) {
        model.addAttribute("username",principal.getName());

        return "addcategory.jsp";
    }


    ////////edit
    @RequestMapping("/edit/{aa}/{id}")
    public String edit(Principal principal,
                       @PathVariable("aa") String test,
                       @PathVariable("id") Long id,
                       @ModelAttribute("income") Income income,
                       @ModelAttribute("plan") Plan plan,
                       @ModelAttribute("expense") Expense expense,
                       @ModelAttribute("cate") Category cate,
                       BindingResult result,
                       Model model,RedirectAttributes rAttributes) {
        User user = userService.findUserByUsername(principal.getName());
        List<Income> incomes=user.getIncomes();
        List<Plan> plans=user.getPlans();
        List<Expense> expenses=null;
        for (Plan pland : plans) {
            if(expenses==null) {
                expenses = pland.getExpenses();
            }
            else{
                for(Expense i:pland.getExpenses())
                    expenses.add(i);
            }
        }
        if(incomes==null){rAttributes.addFlashAttribute("errori","this field is empty");}
        if(plans==null){rAttributes.addFlashAttribute("errorp","this field is empty");}
        if(expenses==null){rAttributes.addFlashAttribute("errore","this field is empty");}
        int testa=1;
        if(test.equals("i")){
            testa=0;
            model.addAttribute("income",mainService.incomeid(id)) ;

        }
        else if(test.equals("p")){
            testa=1;
            model.addAttribute("plan",mainService.planid(id)) ;

        }
        else if(test.equals("e")){
            testa=2;
            model.addAttribute("expense",mainService.expenseid(id)) ;
        }
        else if(test.equals("c")){
            testa=3;
            model.addAttribute("category",mainService.categoryid(id)) ;
        }
        model.addAttribute("user",user);
        model.addAttribute("testa",testa);
        model.addAttribute("username",principal.getName());
        model.addAttribute("incomes",incomes);
        model.addAttribute("plans",plans);
        model.addAttribute("expenses",expenses);
        model.addAttribute("categories",mainService.findAllCategory());
        System.out.println(testa);
        return "edit.jsp";
    }
///////response

    @RequestMapping(value="/editincome/{id}",method = RequestMethod.POST)
    public String editicome(Principal principal, @Valid@ModelAttribute("income") Income income,
                            @PathVariable("id") Long id,
                            BindingResult result) {
        if(result.hasErrors()){
            return "redirect:/edit.jsp";
        }
        Income inc=mainService.incomeid(id);
        inc=income;
//        mainService.updateIncome(inc);
        return "redrect:/edit";
    }
    @RequestMapping(value="/editplan/{id}",method = RequestMethod.POST)
    public String editplan(Principal principal, @Valid@ModelAttribute("plan") Plan plan,
                            @PathVariable("id") Long id,
                            BindingResult result) {
        if(result.hasErrors()){
            return "redirect:/edit.jsp";
        }
        Plan pl=mainService.planid(id);
        pl=plan;
        return "redrect:/edit";
    }
    @RequestMapping(value="/editexpense/{id}",method = RequestMethod.POST)
    public String editexpense(Principal principal, @Valid@ModelAttribute("expense") Expense expense,
                           @PathVariable("id") Long id, BindingResult result) {
        if(result.hasErrors()){
            return "redirect:edit.jsp";
        }
        Expense exp=mainService.expenseid(id);
        exp=expense;
        return "redrect:/edit";
    }
    @RequestMapping(value="/editcat/{id}",method = RequestMethod.POST)
    public String editplan(Principal principal, @Valid@ModelAttribute("cate") Category cate,
                           @PathVariable("id") Long id,
                           BindingResult result) {
        if(result.hasErrors()){
            return "redirect:/edit.jsp";
        }
        Category category=mainService.categoryid(id);
        category=cate;
        return "redrect:/edit";
    }


//////////////////////////delete



    @RequestMapping("/deletecat/{id}")
    public String dc(Principal principal, @PathVariable("id") Long id) {

        mainService.deleteCategory(id);
        return "redrect:/edit/i/1";
    }
    @RequestMapping("/deleteexpense/{id}")
    public String dex(Principal principal, @PathVariable("id") Long id) {
        User user = userService.findUserByUsername(principal.getName());
        mainService.deleteExpense(user,id);
        return "redrect:/edit/i/1";
    }
    @RequestMapping("/deleteplan/{id}")
    public String deleteplan(Principal principal, @PathVariable("id") Long id) {
        mainService.deletePlan(id);
        return "redrect:/edit/i/1";
    }
    @RequestMapping("/deleteincome/{id}")
    public String dincome(Principal principal, @PathVariable("id") Long id) {
        User user = userService.findUserByUsername(principal.getName());
        mainService.deleteIncome(user,id);
        return "redrect:/edit/i/1";
    }





}

