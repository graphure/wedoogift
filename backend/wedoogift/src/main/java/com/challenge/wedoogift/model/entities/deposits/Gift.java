package com.challenge.wedoogift.model.entities.deposits;

import com.challenge.wedoogift.model.abstracts.Deposit;
import com.challenge.wedoogift.model.entities.user.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Gift extends Deposit {

    public Gift(Double amount, LocalDate creationDate) {
        this.amount = amount;
        this.setCreationDate(creationDate);
    }

    public void setEndOfValidityDate() {
        this.endOfValidityDate = this.creationDate.plusYears(1).minusDays(1);
    }

}
