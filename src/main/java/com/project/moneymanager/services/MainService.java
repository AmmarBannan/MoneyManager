package com.project.moneymanager.services;

import com.project.moneymanager.models.*;
import com.project.moneymanager.repositories.*;
import org.apache.tomcat.util.http.ConcurrentDateFormat;
import org.eclipse.jdt.internal.compiler.ast.SwitchStatement;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class MainService {
    private final PlanRepository planRepository;
    private final RoleRepository roleRepository;
    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;
    private final CategoryRepository categoryRepository;

    public MainService(PlanRepository planRepository, RoleRepository roleRepository, IncomeRepository incomeRepository, ExpenseRepository expenseRepository, CategoryRepository categoryRepository) {
        this.planRepository = planRepository;
        this.roleRepository = roleRepository;
        this.incomeRepository = incomeRepository;
        this.expenseRepository = expenseRepository;
        this.categoryRepository = categoryRepository;
    }

    public void addExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    public void addIncome(Income income) {
        incomeRepository.save(income);
    }

    public void deleteIncome(Long id) {
        incomeRepository.deleteById(id);
    }

    public Plan addPlan(Plan plan) {
        planRepository.save(plan);
        return plan;
    }

    public void deletePlan(Long id) {
        planRepository.deleteById(id);
    }

    public List<Plan> findAllPlans() {
        return (List<Plan>) planRepository.findAll();
    }

    public List<Expense> findAllExpenses() {
        return (List<Expense>) expenseRepository.findAll();
    }

    public List<Income> findAllIncomes() {
        return (List<Income>) incomeRepository.findAll();
    }
    public List<Category> findAllCategory() {
        return (List<Category>) categoryRepository.findAll();
    }
//    public void addCategory(Category category) {
//        categoryRepository.save(category);
//    }
    public Category createCategory(Category b) {
        return categoryRepository.save(b);
    }
    public Category findCategory(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            return null;
        }
    }
    public void plantoexp(Expense e,Plan p){
        e.setPlan(p);
    }

    public Income createIncome(Income income) {
        return incomeRepository.save(income);
    }
    public void updateIncome(Income income) {
        incomeRepository.save(income);
    }
    public List<Income> getAllIncomes() {
        return (List<Income>) incomeRepository.findAll();
    }
    public Income findIncome(Long id) {
        Optional<Income> income = incomeRepository.findById(id);
        if (income.isPresent()) {
            return income.get();
        }else {
            return null;
        }
    }
    //connection
    public Plan findplanbydate(User user, Date d){
        for(Plan plan:user.getPlans()) {
            Date a=plan.getStart_datez();
            Date b=plan.getEnd_datez();
            // the date in question
            if(a.compareTo(d) * d.compareTo(b) > 0){
                return plan;
            }
        }
        return null;
    }
    public LocalDate getLocalDate() {
        return LocalDate.now();
    }


}
