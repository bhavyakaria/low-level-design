package com.bhavyakaria.low_level_design.splitwise.models.split;

import com.bhavyakaria.low_level_design.splitwise.models.User;

public abstract class Split {
    private User user;
    private double amount;

    public Split(User user) {
        this.user = user;
        this.amount = amount;
    }

    public Split(User user, double amount) {
        this.user = user;
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
