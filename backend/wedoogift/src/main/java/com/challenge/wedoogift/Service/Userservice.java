package com.challenge.wedoogift.Service;

import com.challenge.wedoogift.model.entities.deposits.Gift;
import com.challenge.wedoogift.model.entities.deposits.Meal;
import com.challenge.wedoogift.model.entities.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Userservice {

    public Double getMealBalance(User user) {
        List<Meal> meals = user.getMeals();
        return meals.stream().filter(
                meal -> meal.isValid()
        ).mapToDouble(Meal::getAmount).sum();
    }

    public Double getGiftBalance(User user) {
        List<Gift> gifts = user.getGifts();
        return gifts.stream().filter(
                gift -> gift.isValid()
        ).mapToDouble(Gift::getAmount).sum();
    }
}
