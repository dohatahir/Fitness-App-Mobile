package com.example.fitness.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class UserMeal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Timestamp dateAndTime;
    @OneToOne
    private Meal meal;
    @OneToOne
    private User user;

    public UserMeal(Meal meal, User user, Timestamp dateAndTime) {
        this.meal = meal;
        this.user = user;
        this.dateAndTime = dateAndTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Timestamp dateAndTime) {
        this.dateAndTime = dateAndTime;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public UserMeal() {

    }
}