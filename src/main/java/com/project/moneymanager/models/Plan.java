package com.project.moneymanager.models;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "plans")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
<<<<<<< HEAD
    private int maxlimit;
    private Date startdate;
    private Date enddate;
=======
    private int limitz;
    private Date start_datez;
    private Date end_datez;
>>>>>>> 80f1d6f64dc5908f5bad97e2f28aee73473b75be
    @Column(updatable = false)
    private Date createdAt;
    private Date updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "plan", fetch = FetchType.LAZY)
    private List<Expense> expenses;

    public Plan() {
    }

<<<<<<< HEAD
    public Plan(String name, int maxlimit, Date startdate, Date enddate) {
        this.name = name;
        this.maxlimit = maxlimit;
        this.startdate = startdate;
        this.enddate = enddate;
=======
    public Plan(int limitz, String name, Date start_datezz, Date end_datez) {
        this.limitz = limitz;
        this.name = name;
        this.start_datez = start_datez;
        this.end_datez = end_datez;
>>>>>>> 80f1d6f64dc5908f5bad97e2f28aee73473b75be
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

<<<<<<< HEAD
=======
    public int getlimitz() {
        return limitz;
    }

    public void setlimitz(int limitz) {
        this.limitz = limitz;
    }

>>>>>>> 80f1d6f64dc5908f5bad97e2f28aee73473b75be
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

<<<<<<< HEAD
    public int getMaxlimit() {
        return maxlimit;
    }

    public void setMaxlimit(int maxlimit) {
        this.maxlimit = maxlimit;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
=======
    public Date getstart_datez() {
        return start_datez;
    }

    public void setstart_datez(Date start_datez) {
        this.start_datez = start_datez;
    }

    public Date getend_datez() {
        return end_datez;
    }

    public void setend_datez(Date end_datez) {
        this.end_datez = end_datez;
>>>>>>> 80f1d6f64dc5908f5bad97e2f28aee73473b75be
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PostPersist
    protected void onUpdate() {
        this.updatedAt = new Date();
    }


}
