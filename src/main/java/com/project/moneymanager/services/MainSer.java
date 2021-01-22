package com.project.moneymanager.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.moneymanager.models.Category;
import com.project.moneymanager.models.Expense;
import com.project.moneymanager.models.Income;
import com.project.moneymanager.models.Plan;
import com.project.moneymanager.models.Role;
import com.project.moneymanager.repositories.CategoryRepository;
import com.project.moneymanager.repositories.ExpenseRepository;
import com.project.moneymanager.repositories.IncomeRepository;
import com.project.moneymanager.repositories.PlanRepository;
import com.project.moneymanager.repositories.RoleRepository;

@Service
public class MainSer {
	private final PlanRepository planRepository;
    private final RoleRepository roleRepository;
    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;
    private final CategoryRepository categoryRepository;

    public MainSer(PlanRepository planRepository, RoleRepository roleRepository, IncomeRepository incomeRepository, ExpenseRepository expenseRepository, CategoryRepository categoryRepository) {
        this.planRepository = planRepository;
        this.roleRepository = roleRepository;
        this.incomeRepository = incomeRepository;
        this.expenseRepository = expenseRepository;
        this.categoryRepository = categoryRepository;
    }
    //delete
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
    public void deletePlan(Long id) {
        planRepository.deleteById(id);
    }
     public void deleteIncome(Long id) {
        incomeRepository.deleteById(id);
    }
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
    
    //add
    public void addIncome(Income income) {
        incomeRepository.save(income);
    }
    public void addExpense(Expense expense) {
        expenseRepository.save(expense);
    }
    public void addPlan(Plan plan) {
        planRepository.save(plan);
    }
    public void addRole(Role role ) {
        roleRepository.save(role);
    }
    
    //find all
    public List<Plan> findAllPlans() {
        return (List<Plan>) planRepository.findAll();
    }
    public List<Expense> findAllExpenses() {
    return (List<Expense>) expenseRepository.findAll();
    }
    public List<Income> findAllIncomes() {
        return (List<Income>) incomeRepository.findAll();
    }
    public List<Role> findAllRoll() {
        return (List<Role>) roleRepository.findAll();
    }
    public List<Category> findAllCategory() {
        return (List<Category>) categoryRepository.findAll();
    }




}
