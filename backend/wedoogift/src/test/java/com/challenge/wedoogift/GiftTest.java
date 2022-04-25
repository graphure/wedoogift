package com.challenge.wedoogift;

import com.challenge.wedoogift.Service.BalanceService;
import com.challenge.wedoogift.model.entities.Finance.Balance;
import com.challenge.wedoogift.model.entities.deposits.Gift;
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
public class GiftTest {

    @Autowired
    BalanceService balanceService;

    @Test
    void testValidationDateGift() {
        Gift newGift = new Gift(new Double(300), LocalDate.parse("2021-06-15"));
        Assert.isTrue(newGift.endOfValidityDate.equals(LocalDate.parse("2022-06-14")), "The end of validity should be one year later");
    }

    @Test
    void giftCreationCondition() {
        Gift newGift = new Gift(new Double(300), LocalDate.now());
        Balance excedenceBalance = new Balance(400.0);
        Balance deficitBalance = new Balance(200.0);
        Assert.isTrue(balanceService.sufficientAmount(excedenceBalance, newGift.amount), "The balance total amount should exceed the Gift price");
        Assert.isTrue(!balanceService.sufficientAmount(deficitBalance, newGift.amount), "If the balance total doesn't exceed the Gift price, it shouldn't be offert");
    }
}
