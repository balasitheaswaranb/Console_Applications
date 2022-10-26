package com.expense.controller;

import java.util.List;

import com.expense.model.Database;
import com.expense.model.ExpenseData;

public class ExpenseController {

	private ExpenseData expenseData;
	private InputController inputController = new InputController();

	public void toAddTransaction() {
		expenseData = new ExpenseData();
		expenseData.setDate(inputController.getInput("Date (DD/MM/YYYY) : ",
				"(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/][0-9]{4}"));
		expenseData.setKind(inputController.getInput("Kind (Income/Expense) : ", "Income|Expense|income|expense"));
		expenseData.setCategory(inputController.getInput("Category : ", "[A-Za-z ]+"));
		expenseData.setAmount(Integer.valueOf(inputController.getInput("Amount : Rs.", "[0-9]+")));
		expenseData.setDescription(inputController.getInput("Description : ", ".+"));
		Database.getInstance().insertTransaction(expenseData);
	}

	public List<ExpenseData> getDatabaseList() {
		List<ExpenseData> transactionList = Database.getInstance().getTransactionList();
		return transactionList;
	}

}
