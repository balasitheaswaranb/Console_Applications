package com.expense.view;

import java.util.Iterator;

import com.expense.controller.ExpenseController;
import com.expense.controller.InputController;
import com.expense.model.ExpenseData;

public class ManageExpense {

	private ExpenseController expenseController;
	private InputController inputController;

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
		Iterator<ExpenseData> iterator = expenseController.getDatabaseList().iterator();
		while (iterator.hasNext()) {
			ExpenseData expenseData = iterator.next();
			System.out.printf(format, (i++), expenseData.getDate(), expenseData.getKind(), expenseData.getCategory(),
					expenseData.getAmount(), expenseData.getDescription() + "\n");
		}
		viewBalance();
	}

	public void viewBalance() {
		int totalIncome = 0, totalExpense = 0;
		Iterator<ExpenseData> iterator = expenseController.getDatabaseList().iterator();
		while (iterator.hasNext()) {
			ExpenseData expenseData = iterator.next();
			if (expenseData.getKind().equalsIgnoreCase("Income")) {
				totalIncome += expenseData.getAmount();
			} else {
				totalExpense += expenseData.getAmount();
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

	public void searchTransaction() {
		String category = inputController.getInput("Category : ", "[A-Za-z ]+");
		String format = "\n%-5s %-10s %-10s %-20s %-15s %-20s";
		Iterator<ExpenseData> iterator = expenseController.getDatabaseList().iterator();
		int i = 1;
		while (iterator.hasNext()) {
			ExpenseData expenseData = iterator.next();
			if ((expenseData.getCategory().equalsIgnoreCase(category))) {
				System.out.printf(format, "S.no", "Date", "Kind", "Category", "Amount", "Description\n");
				System.out.printf(format, (i++), expenseData.getDate(), expenseData.getKind(),
						expenseData.getCategory(), expenseData.getAmount(), expenseData.getDescription() + "\n");
			}
		}
	}
}
