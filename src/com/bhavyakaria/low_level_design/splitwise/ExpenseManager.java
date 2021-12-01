package com.bhavyakaria.low_level_design.splitwise;

import com.bhavyakaria.low_level_design.splitwise.enums.ExpensesType;
import com.bhavyakaria.low_level_design.splitwise.models.User;
import com.bhavyakaria.low_level_design.splitwise.models.expense.Expense;
import com.bhavyakaria.low_level_design.splitwise.models.split.Split;
import com.bhavyakaria.low_level_design.splitwise.services.ExpenseService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {

    HashMap<String, User> users;
    HashMap<String, HashMap<String, Double>> balanceSheet;
    List<Expense> expenses;

    public ExpenseManager() {
        this.users = new HashMap<>();
        this.balanceSheet = new HashMap<>();
        this.expenses = new ArrayList<>();
    }

    public void addUser(User user) {
        users.put(user.getUserId(), user);
        balanceSheet.put(user.getUserId(), new HashMap<String, Double>());
    }

    public void showBalances() {
        boolean isEmpty = true;
        for (Map.Entry<String, HashMap<String, Double>> allBalances : balanceSheet.entrySet()) {
            for (Map.Entry<String, Double> userBalance : allBalances.getValue().entrySet()) {
                if (userBalance.getValue() > 0) {
                    isEmpty = false;
                    printBalance(allBalances.getKey(), userBalance.getKey(), userBalance.getValue());
                }
            }
        }

        if (isEmpty) {
            System.out.println("No balances");
        }
    }

    public void showBalance(String userId) {
        boolean isEmpty = true;
        for (Map.Entry<String, Double> userBalance : balanceSheet.get(userId).entrySet()) {
            if (userBalance.getValue() != 0) {
                isEmpty = false;
                printBalance(userId, userBalance.getKey(), userBalance.getValue());
            }
        }

        if (isEmpty) {
            System.out.println("No balances");
        }
    }

    public void addExpense(ExpensesType expensesType, User paidBy, double amountPaid, List<Split> splits) {
        try {
            Expense expense = ExpenseService.createExpense(expensesType, paidBy, amountPaid, splits);
            expenses.add(expense);
            for (Split split : expense.getSplits()) {
            User paidFor = split.getUser();

            HashMap<String, Double> paidForBalances = balanceSheet.get(paidFor.getUserId());
            HashMap<String, Double> paidByBalances = balanceSheet.get(paidBy.getUserId());

            if (!paidByBalances.containsKey(paidFor.getUserId())) {
                paidByBalances.put(paidFor.getUserId(), 0.0);
            }

            if (!paidForBalances.containsKey(paidBy.getUserId())) {
                paidForBalances.put(paidBy.getUserId(), 0.0);
            }

            paidByBalances.put(paidFor.getUserId(), paidByBalances.get(paidFor.getUserId()) + split.getAmount());
            paidForBalances.put(paidBy.getUserId(), paidForBalances.get(paidBy.getUserId()) - split.getAmount());

//                String paidTo = split.getUser().getUserId();
//                Map<String, Double> balances = balanceSheet.get(paidBy.getUserId());
//                if (!balances.containsKey(paidTo)) {
//                    balances.put(paidTo, 0.0);
//                }
//                balances.put(paidTo, balances.get(paidTo) + split.getAmount());
//
//                balances = balanceSheet.get(paidTo);
//                if (!balances.containsKey(paidBy.getUserId())) {
//                    balances.put(paidBy.getUserId(), 0.0);
//                }
//                balances.put(paidBy.getUserId(), balances.get(paidBy.getUserId()) - split.getAmount());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void printBalance(String user1, String user2, double amount) {
        String user1Name = users.get(user1).getName();
        String user2Name = users.get(user2).getName();
        if (amount < 0) {
            System.out.println(user1Name + " owes " + user2Name + ": " + Math.abs(amount));
        } else if (amount > 0) {
            System.out.println(user2Name + " owes " + user1Name + ": " + Math.abs(amount));
        }
    }
}
