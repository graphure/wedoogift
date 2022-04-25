package com.challenge.wedoogift;

import com.challenge.wedoogift.Service.Userservice;
import com.challenge.wedoogift.model.entities.deposits.Gift;
import com.challenge.wedoogift.model.entities.deposits.Meal;
import com.challenge.wedoogift.model.entities.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class UserTest {

    @Autowired
    Userservice userservice;

    @Test
    void testUserBalance() {
        User newUser = new User();
        List<Gift> gifts = new ArrayList<>();
        //Valid gifts
        gifts.add(new Gift(new Double(100), LocalDate.now()));
        gifts.add(new Gift(new Double(100), LocalDate.now()));
        //Outdated gifts
        gifts.add(new Gift(new Double(100), LocalDate.parse("2014-02-24")));
        gifts.add(new Gift(new Double(100), LocalDate.parse("2013-02-25")));

        newUser.setGifts(gifts);
        Assert.isTrue(userservice.getGiftBalance(newUser).equals(new Double(200)), "OutDated gifts should not be counted");

        List<Meal> meals = new ArrayList<>();
        //Valid gifts
        meals.add(new Meal(new Double(100), LocalDate.now()));
        meals.add(new Meal(new Double(100), LocalDate.now()));
        //Outdated gifts
        meals.add(new Meal(new Double(100), LocalDate.parse("2014-02-24")));
        meals.add(new Meal(new Double(100), LocalDate.parse("2014-02-25")));

        newUser.setMeals(meals);
        Assert.isTrue(userservice.getMealBalance(newUser).equals(new Double(200)), "OutDated gifts should not be counted");
    }
}
