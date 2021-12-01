package com.bhavyakaria.low_level_design.splitwise.models.split;

import com.bhavyakaria.low_level_design.splitwise.models.User;

public class ExactSplit extends Split {
    double amount;
    public ExactSplit(User user, double amount) {
        super(user);
        this.amount = amount;
    }
}
