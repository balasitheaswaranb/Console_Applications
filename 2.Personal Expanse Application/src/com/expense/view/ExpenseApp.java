package com.expense.view;

public class ExpenseApp {
	private ViewMenu menu = new ViewMenu();

	public static void main(String[] args) {
		ExpenseApp expenseApp = new ExpenseApp();
		expenseApp.start();
        
	}

	private void start() {
		System.out.println("********** Welcome to Expense manager app **********");
		menu.initiate();
	}

}
