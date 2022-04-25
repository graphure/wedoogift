package com.challenge.wedoogift.model.abstracts;

import com.challenge.wedoogift.model.entities.Finance.Balance;
import com.challenge.wedoogift.model.entities.user.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public abstract class Deposit {

    public LocalDate creationDate;
    public LocalDate endOfValidityDate;

    public Double amount;

    public User user;

    public Balance balance;

    public Boolean isValid() {
        return endOfValidityDate.isAfter(LocalDate.now());
    }

    public abstract void setEndOfValidityDate();

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
        this.setEndOfValidityDate();
    }
}
