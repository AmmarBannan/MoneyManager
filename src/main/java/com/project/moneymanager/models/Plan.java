package com.project.moneymanager.models;


import org.springframework.format.annotation.DateTimeFormat;

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

<<<<<<< HEAD
    @Entity
    @Table(name = "plans")
    public class Plan {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private int limitz;
        @DateTimeFormat(pattern="yyyy-MM-dd")
        private Date start_datez;
        @DateTimeFormat(pattern="yyyy-MM-dd")
        private Date end_datez;
        @Column(updatable = false)
        private Date createdAt;
        private Date updatedAt;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
        private User user;
        @OneToMany(mappedBy = "plan", fetch = FetchType.LAZY)
        private List<Expense> expenses;


        public Plan(){}
=======

@Entity
@Table(name = "plans")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int limitz;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date start_datez;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date end_datez;
    @Column(updatable = false)
    private Date createdAt;
    private Date updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "plan", fetch = FetchType.LAZY)
    private List<Expense> expenses;


    public Plan(){}
>>>>>>> b59787f4103aa518a01d69b83b5af0496316177d

//    public Plan(String name, int limitz, Date start_datez, Date end_datez, User user) {
//        this.name = name;
//        this.limitz = limitz;
//        this.start_datez = start_datez;
//        this.end_datez = end_datez;
//        this.user = user;
//    }

<<<<<<< HEAD
        public Long getId() {
            return id;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getLimitz() {
            return limitz;
        }

        public void setLimitz(int limitz) {
            this.limitz = limitz;
        }

        public Date getStart_datez() {
            return start_datez;
        }

        public void setStart_datez(Date start_datez) {
            this.start_datez = start_datez;
        }

        public Date getEnd_datez() {
            return end_datez;
        }

        public void setEnd_datez(Date end_datez) {
            this.end_datez = end_datez;
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
=======
    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLimitz() {
        return limitz;
    }

    public void setLimitz(int limitz) {
        this.limitz = limitz;
    }

    public Date getStart_datez() {
        return start_datez;
    }

    public void setStart_datez(Date start_datez) {
        this.start_datez = start_datez;
    }

    public Date getEnd_datez() {
        return end_datez;
    }

    public void setEnd_datez(Date end_datez) {
        this.end_datez = end_datez;
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
>>>>>>> b59787f4103aa518a01d69b83b5af0496316177d
