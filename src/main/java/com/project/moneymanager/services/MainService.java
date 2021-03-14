package com.project.moneymanager.services;

import com.project.moneymanager.models.*;
import com.project.moneymanager.repositories.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class MainService {
    private final PlanRepository planRepository;
    private final RoleRepository roleRepository;
    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;
    private final CategoryRepository categoryRepository;
    private final Balancerepo balacerepo;
    private final NoteRepo noterepo;

    public MainService( NoteRepo noterepo,Balancerepo balacerepo,PlanRepository planRepository, RoleRepository roleRepository, IncomeRepository incomeRepository, ExpenseRepository expenseRepository, CategoryRepository categoryRepository) {
        this.planRepository = planRepository;
        this.roleRepository = roleRepository;
        this.incomeRepository = incomeRepository;
        this.expenseRepository = expenseRepository;
        this.categoryRepository = categoryRepository;
        this.balacerepo=balacerepo;
        this.noterepo=noterepo;
    }

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

    public void updateIncome(Income income) {
        incomeRepository.save(income);
    }
    public List<Income> getAllIncomes() {
        return (List<Income>) incomeRepository.findAll();
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

//finding
    public Income incomeid(Long id){
        return incomeRepository.findById(id).orElse(null);
    }
    public Plan planid(Long id){
        return planRepository.findById(id).orElse(null);
    }
    public Expense expenseid(Long id){
        return expenseRepository.findById(id).orElse(null);
    }
    public Category categoryid(Long id){return categoryRepository.findById(id).orElse(null);}

    //delete
    public void deleteExpense(User user,Long id) { this.transaction(user);expenseRepository.deleteById(id); }
    public void deleteIncome(User u,Long id) { this.transaction(u);incomeRepository.deleteById(id); }

    public void deletePlan(Long id) {
        planRepository.deleteById(id);
    }
    public void deleteCategory(Long id) { categoryRepository.deleteById(id); }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }



    //add
    public Income addIncome(User u,Income income) {
        income.setUser(u);
        this.transaction(u);
        return incomeRepository.save(income);

    }
    public Expense addExpense(User u,Expense expense) {
        this.transaction(u);
        return expenseRepository.save(expense);
    }
    public Plan addPlan(Plan plan) {
        planRepository.save(plan);
        return plan;
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

    //add to balance
    public Balance adding(User u,int d){
        int x=0;
       for(Balance b:u.getBalances()){
           if(b==null){
               x=b.getVal();
           }
       }
        Balance bal=new Balance(u,d+x);
        balacerepo.save(bal);
        return bal;
    }
    public Balance taking(User u,int d){
        int x=0;
        for(Balance b:u.getBalances()){
            if(b==null){
                x=b.getVal();
            }
        }
        Balance bal=new Balance(u,x-d);
        balacerepo.save(bal);
        return bal;
    }
    public Balance getlastbalance(User u){
        Balance bal=null;
        for(Balance b:u.getBalances()){
            bal=b;
        }
        if(bal==null){
            bal=new Balance(u,0);
            balacerepo.save(bal);
        }

        return  bal;
    }

    public Balance transaction(User u){
        if(u.getBalances().size()<1){
            Balance balance=new Balance(u,0);
            balacerepo.save(balance);
            return balance;
        }
        else {
            int total = 0;
            for (Income i : this.getAllIncomes()) {
                total += i.getAmount();
            }
            for (Expense i : this.findAllExpenses()) {
                total -= i.getAmount();
            }
            Balance bal = new Balance(u, total);
            balacerepo.save(bal);
            return bal;
        }
    }
    //add note
    public Note createnote(User u,Note note){
        note.setUser(u);
        noterepo.save(note);
        return note;
    }
    public void deletenote(Note note){
        noterepo.delete(note);
    }
    public Note editnote(Note n,String str){
        n.setDescription(str);
        return n;
    }



}
