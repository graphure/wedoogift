package com.challenge.wedoogift.Service;

import com.challenge.wedoogift.model.entities.Finance.Balance;
import org.springframework.stereotype.Service;

@Service
public class BalanceService {

    public Boolean sufficientAmount(Balance balance, Double amount) {
        return amount < balance.getTotalStockholder();
    }
}
