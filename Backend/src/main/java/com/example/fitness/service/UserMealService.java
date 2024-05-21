package com.example.fitness.service;

import com.example.fitness.model.Meal;
import com.example.fitness.model.UserMeal;
import com.example.fitness.repository.MealRepository;
import com.example.fitness.repository.UserMealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserMealService {
    @Autowired
    private UserMealRepository userMealRepository;
    @Autowired
    private MealRepository mealRepository;


    public void deleteUserMeal(Long id) {
        if (!userMealRepository.existsById(id)) {
            throw new RuntimeException("UserMeal not found with id: " + id);
        } else {
            userMealRepository.deleteById(id);
            System.out.println("UserMeal deleted with id: " + id);
        }
    }

    public UserMeal addMealToCart(Long mealId) {
        Meal meal = mealRepository.findById(mealId).orElseThrow(() -> new RuntimeException("Meal not found with id: " + mealId));


        UserMeal existingUserMeal = userMealRepository.findByMealAndUser(meal, null);

        if (existingUserMeal != null) {
            // If the meal already exists, increment the quantity
            existingUserMeal.setDateAndTime(getCurrentTimestamp());
            return userMealRepository.save(existingUserMeal);
        } else {
            // If the meal does not exist, add it as a new entry
            UserMeal newUserMeal = new UserMeal(meal, null, getCurrentTimestamp());
            return userMealRepository.save(newUserMeal);
        }
    }
    private Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }


    public UserMealService(UserMealRepository userMealRepository) {
        this.userMealRepository = userMealRepository;
    }

    public List<UserMeal> findAll() {
        // Get current date
        LocalDate currentDate = LocalDate.now();
        // Get current date time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Check if it's past midnight (00:00)
        if (currentDateTime.getHour() == 0 && currentDateTime.getMinute() == 0 && currentDateTime.getSecond() == 0) {
            // If it's past midnight, return an empty list
            return List.of();
        } else {
            // If it's not past midnight, return all UserMeal entries
            return userMealRepository.findAll();
        }
    }
}