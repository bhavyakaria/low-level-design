package com.bhavyakaria.low_level_design.splitwise.models.expense;

import com.bhavyakaria.low_level_design.splitwise.models.User;
import com.bhavyakaria.low_level_design.splitwise.models.split.ExactSplit;
import com.bhavyakaria.low_level_design.splitwise.models.split.Split;

import java.util.List;

public class ExactExpense extends Expense{


    public ExactExpense(double amount, User paidBy, List<Split> splits) {
        super(amount, paidBy, splits);
    }

    @Override
    public boolean validate() {
        for (Split split : getSplits()) {
            if (!(split instanceof ExactSplit)) return false;
        }
        double sum = 0;
        for (Split split : getSplits()) {
            sum = sum + split.getAmount();
        }

        if (sum != getAmount()) return false;
        return true;
    }
}
