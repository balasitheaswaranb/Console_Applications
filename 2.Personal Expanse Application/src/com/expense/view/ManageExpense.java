package com.expense.view;

import java.util.Iterator;

import com.expense.controller.ExpenseController;
import com.expense.controller.InputController;
import com.expense.model.ExpenseDatas;

public class ManageExpense {

	 ExpenseController expenseController;
     InputController inputController;

	public ManageExpense() {
		expenseController = new ExpenseController();
		inputController = new InputController();
	}

	protected void addTransaction() {
		expenseController.toAddTransaction();
		System.out.print("Transaction added Successfully!!");
	}

	protected void viewAllExpense() {
		String format = "\n%-5s %-15s %-15s %-20s %-15s %-20s";
		System.out.printf(format, "S.no", "Date", "Kind", "Category", "Amount", "Description\n");
		int i = 1;
		Iterator<ExpenseDatas> iterator = expenseController.getDatabaseList().iterator();
		while (iterator.hasNext()) {
			ExpenseDatas expenseDatas = iterator.next();
			System.out.printf(format, (i++), expenseDatas.getDate(), expenseDatas.getKind(), expenseDatas.getCategory(),
					expenseDatas.getAmount(), expenseDatas.getDescription() + "\n");
		}
		viewBalance();
	}

	protected void viewBalance() {
		int totalIncome = 0, totalExpense = 0;
		Iterator<ExpenseDatas> iterator = expenseController.getDatabaseList().iterator();
		while (iterator.hasNext()) {
			ExpenseDatas expenseDatas = iterator.next();
			if (expenseDatas.getKind().equalsIgnoreCase("Income")) {
				totalIncome += expenseDatas.getAmount();
			} else {
				totalExpense += expenseDatas.getAmount();
			}
		}
		System.out.println("\n\nTotal Income Earned ----> Rs." + totalIncome);
		System.out.println("\nTotal Expense Made ----> Rs." + totalExpense);
		if (totalIncome > totalExpense) {
			System.out.println("\nBalance  --> Rs. " + (totalIncome - totalExpense));
		} else if (totalIncome < totalExpense) {
			System.out.println("\nBalance  --> Rs. -" + (totalExpense - totalIncome));
		} else {
			System.out.println("\nBalance --> Rs.0");
		}
	}

	protected void searchTransaction() {
		String category = inputController.getInput("Category : ", "[A-Za-z ]+");
		String format = "\n%-5s %-10s %-10s %-20s %-15s %-20s";
		Iterator<ExpenseDatas> iterator = expenseController.getDatabaseList().iterator();
		int i = 1;
		while (iterator.hasNext()) {
			ExpenseDatas expenseDatas = iterator.next();
			if ((expenseDatas.getCategory().equalsIgnoreCase(category))) {
				System.out.printf(format, "S.no", "Date", "Kind", "Category", "Amount", "Description\n");
				System.out.printf(format, (i++), expenseDatas.getDate(), expenseDatas.getKind(),
						expenseDatas.getCategory(), expenseDatas.getAmount(), expenseDatas.getDescription() + "\n");
			}
		}
	}
}
