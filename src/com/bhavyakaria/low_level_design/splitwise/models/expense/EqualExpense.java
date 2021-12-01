package com.bhavyakaria.low_level_design.splitwise.models.expense;

import com.bhavyakaria.low_level_design.splitwise.models.User;
import com.bhavyakaria.low_level_design.splitwise.models.split.EqualSplit;
import com.bhavyakaria.low_level_design.splitwise.models.split.Split;

import java.util.List;

public class EqualExpense extends Expense{

    public EqualExpense(double amount, User paidBy, List<Split> splits) {
        super(amount, paidBy, splits);
    }

    @Override
    public boolean validate() {
        for (Split split : getSplits()) {
            if (!(split instanceof EqualSplit)) return false;
        }
        return true;
    }
}
