package com.example.fitness.repository;

import com.example.fitness.model.Meal;
import com.example.fitness.model.User;
import com.example.fitness.model.UserMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMealRepository extends JpaRepository<UserMeal, Long> {
    UserMeal findByMealAndUser(Meal meal, User user);


}
