package com.challenge.wedoogift.model.entities.Finance;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Balance {

    Double totalStockholder;

    public Balance( Double amount){
        this.totalStockholder=amount;
    }

}
