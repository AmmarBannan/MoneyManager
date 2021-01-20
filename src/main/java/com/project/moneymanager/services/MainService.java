package com.project.moneymanager.services;

import com.project.moneymanager.models.Category;
import com.project.moneymanager.models.Expense;
import com.project.moneymanager.models.Income;
import com.project.moneymanager.models.Plan;
import com.project.moneymanager.repositories.*;
import org.springframework.stereotype.Service;

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

    public void addPlan(Plan plan) {
        planRepository.save(plan);
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


}
