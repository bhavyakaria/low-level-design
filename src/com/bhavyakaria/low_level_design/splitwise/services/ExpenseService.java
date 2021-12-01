package com.bhavyakaria.low_level_design.splitwise.services;

import com.bhavyakaria.low_level_design.splitwise.enums.ExpensesType;
import com.bhavyakaria.low_level_design.splitwise.models.User;
import com.bhavyakaria.low_level_design.splitwise.models.expense.EqualExpense;
import com.bhavyakaria.low_level_design.splitwise.models.expense.ExactExpense;
import com.bhavyakaria.low_level_design.splitwise.models.expense.Expense;
import com.bhavyakaria.low_level_design.splitwise.models.expense.PercentExpense;
import com.bhavyakaria.low_level_design.splitwise.models.split.PercentSplit;
import com.bhavyakaria.low_level_design.splitwise.models.split.Split;

import java.util.List;

public class ExpenseService {
    public static Expense createExpense(ExpensesType expensesType, User paidBy, double amountPaid, List<Split> splits) {
        switch (expensesType) {
            case EQUAL:
                int totalSplits = splits.size();
                double splitAmount = (double) Math.round(amountPaid/totalSplits);
                for (Split split : splits) {
                    split.setAmount(splitAmount);
                }
                splits.get(0).setAmount(splitAmount + amountPaid - (splitAmount*totalSplits));
                return new EqualExpense(amountPaid, paidBy, splits);
            case EXACT:
                return new ExactExpense(amountPaid, paidBy, splits);
            case PERCENT:
                for (Split split : splits) {
                    PercentSplit percentSplit = (PercentSplit) split;
                    split.setAmount((amountPaid*percentSplit.getPercent())/100.0);
                }
                return new PercentExpense(amountPaid, paidBy, splits);
            default:
                return null;
        }
    }
}
