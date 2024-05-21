package com.example.fitness.controller;

import com.example.fitness.model.UserMeal;
import com.example.fitness.service.UserMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")

@RequestMapping("/usermeal")
public class UserMealController {

    //@PreAuthorize("hasRole('USER')")
@Autowired
    private UserMealService userMealService;
    @GetMapping("/{mealId}")
    public UserMeal addMealToCart(@PathVariable Long mealId) {
        return userMealService.addMealToCart(mealId);
    }

    @GetMapping("/")
    public List<UserMeal> getAllUserMeals(){
        return userMealService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteUserMeal(@PathVariable Long id){
        userMealService.deleteUserMeal(id);
    }
}
