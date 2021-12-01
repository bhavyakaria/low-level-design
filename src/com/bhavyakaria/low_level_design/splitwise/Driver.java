package com.bhavyakaria.low_level_design.splitwise;

import com.bhavyakaria.low_level_design.splitwise.enums.ExpensesType;
import com.bhavyakaria.low_level_design.splitwise.models.User;
import com.bhavyakaria.low_level_design.splitwise.models.split.EqualSplit;
import com.bhavyakaria.low_level_design.splitwise.models.split.ExactSplit;
import com.bhavyakaria.low_level_design.splitwise.models.split.PercentSplit;
import com.bhavyakaria.low_level_design.splitwise.models.split.Split;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseManager expenseManager = new ExpenseManager();

        expenseManager.addUser(new User("u1", "User1", "gaurav@workat.tech", "9876543210"));
        expenseManager.addUser(new User("u2", "User2", "sagar@workat.tech", "9876543210"));
        expenseManager.addUser(new User("u3", "User3", "hi@workat.tech", "9876543210"));
        expenseManager.addUser(new User("u4", "User4", "mock-interviews@workat.tech", "9876543210"));

        while(true) {
            try {
                String commandString = sc.nextLine();
                String[] commands = commandString.split(" ");

                String commandType = commands[0];

                if (Objects.equals(commandType, "SHOW")) {
                    if (commands.length == 1) {
                        expenseManager.showBalances();
                    } else {
                        expenseManager.showBalance(commands[1]);
                    }
                } else {
                    String paidByUserId = commands[1];
                    double amountPaid = Double.parseDouble(commands[2]);
                    int totalUsers = Integer.parseInt(commands[3]);
                    String expenseType = commands[4 + totalUsers];
                    List<Split> splitList = new ArrayList<>();
                    switch (expenseType) {
                        case "EQUAL":
                            for (int i = 0; i < totalUsers; i++) {
                                splitList.add(new EqualSplit(expenseManager.users.get(commands[4+i])));
                            }
                            expenseManager.addExpense(ExpensesType.EQUAL, expenseManager.users.get(paidByUserId), amountPaid, splitList);
                            break;
                        case "EXACT":
                            for (int i = 0; i < totalUsers; i++) {
                                splitList.add(new ExactSplit(expenseManager.users.get(commands[4+i]), Double.parseDouble(commands[5+totalUsers+i])));
                            }
                            expenseManager.addExpense(ExpensesType.EXACT, expenseManager.users.get(paidByUserId), amountPaid, splitList);
                            break;
                        case "PERCENT":
                            for (int i = 0; i < totalUsers; i++) {
                                splitList.add(new PercentSplit(expenseManager.users.get(commands[4+i]), Double.parseDouble(commands[5+totalUsers+i])));
                            }
                            expenseManager.addExpense(ExpensesType.PERCENT, expenseManager.users.get(paidByUserId), amountPaid, splitList);
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
