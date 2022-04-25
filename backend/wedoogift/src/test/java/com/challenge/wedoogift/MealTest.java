package com.challenge.wedoogift;

import com.challenge.wedoogift.Service.BalanceService;
import com.challenge.wedoogift.model.entities.Finance.Balance;
import com.challenge.wedoogift.model.entities.deposits.Meal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;


@SpringBootTest
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class MealTest {

    @Autowired
    BalanceService balanceService;

    @Test
    void testValidationMeal() {
        Meal newMeal = new Meal(new Double(300), LocalDate.parse("2021-01-01"));
        System.out.println(newMeal.endOfValidityDate);
        Assert.isTrue(newMeal.endOfValidityDate.equals(LocalDate.parse("2022-02-28")), "The end of validity should be end of february the next year");
        Assert.isTrue(!newMeal.isValid(), "The meal is actually outdated");
    }

    @Test
    void giftCreationCondition() {
        Meal newMeal = new Meal(new Double(300), LocalDate.now());
        Balance excedenceBalance = new Balance(400.0);
        Balance deficitBalance = new Balance(200.0);
        Assert.isTrue(balanceService.sufficientAmount(excedenceBalance, newMeal.amount), "The balance total amount should exceed the Gift price");
        Assert.isTrue(!balanceService.sufficientAmount(deficitBalance, newMeal.amount), "If the balance total doesn't exceed the Gift price, it shouldn't be offert");
    }

}
