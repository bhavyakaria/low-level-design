package com.bhavyakaria.low_level_design.splitwise.models.expense;

import com.bhavyakaria.low_level_design.splitwise.models.User;
import com.bhavyakaria.low_level_design.splitwise.models.split.PercentSplit;
import com.bhavyakaria.low_level_design.splitwise.models.split.Split;

import java.util.List;

public class PercentExpense extends Expense{

    public PercentExpense(double amount, User paidBy, List<Split> splits) {
        super(amount, paidBy, splits);
    }

    @Override
    public boolean validate() {
        for (Split split : getSplits()) {
            if (!(split instanceof PercentSplit)) return false;
        }

        int totalPercent = 0;
        for (Split split : getSplits()) {
            PercentSplit percentSplit = (PercentSplit) split;
            totalPercent += percentSplit.getPercent();
        }

        if (totalPercent != 100) return false;
        return true;
    }
}
