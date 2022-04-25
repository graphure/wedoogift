package com.challenge.wedoogift.model.entities.deposits;

import com.challenge.wedoogift.model.abstracts.Deposit;
import com.challenge.wedoogift.model.entities.user.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class Meal extends Deposit {

    public Meal(Double amount, LocalDate creationDate) {
        this.amount = amount;
        this.setCreationDate(creationDate);
    }

    public void setEndOfValidityDate() {
        int endOfValidityYear = this.creationDate.plusYears(1).getYear();
        this.endOfValidityDate = LocalDate.parse(String.valueOf(endOfValidityYear) + "-02-28");
    }
}
