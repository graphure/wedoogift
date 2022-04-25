package com.challenge.wedoogift.model.entities.user;

import com.challenge.wedoogift.model.entities.deposits.Gift;
import com.challenge.wedoogift.model.entities.deposits.Meal;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User {

    public String name;

    public String Surname;

    public List<Gift> gifts;

    public List<Meal> meals;

}
