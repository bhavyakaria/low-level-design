package com.bhavyakaria.low_level_design.splitwise.models.expense;

import com.bhavyakaria.low_level_design.splitwise.models.User;
import com.bhavyakaria.low_level_design.splitwise.models.split.Split;

import java.util.List;

public abstract class Expense {
    private int expenseId = 0;
    private double amount;
    private User paidBy;
    private List<Split> splits;

    public Expense(double amount, User paidBy, List<Split> splits) {
        this.expenseId++;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = splits;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public double getAmount() {
        return amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public abstract boolean validate();
}
