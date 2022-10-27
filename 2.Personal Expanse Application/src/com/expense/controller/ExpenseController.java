package com.expense.controller;

import java.util.List;

import com.expense.model.Database;
import com.expense.model.ExpenseDatas;

public class ExpenseController {

	ExpenseDatas expenseDatas;
	InputController inputController = new InputController();

	public void toAddTransaction() {
		expenseDatas = new ExpenseDatas();
		expenseDatas.setDate(inputController.getInput("Date (DD/MM/YYYY) : ",
				"(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/][0-9]{4}"));
		expenseDatas.setKind(inputController.getInput("Kind (Income/Expense) : ", "Income|Expense|income|expense"));
		expenseDatas.setCategory(inputController.getInput("Category : ", "[A-Za-z ]+"));
		expenseDatas.setAmount(Integer.valueOf(inputController.getInput("Amount : Rs.", "[0-9]+")));
		expenseDatas.setDescription(inputController.getInput("Description : ", ".+"));
		Database.getInstance().insertTransaction(expenseDatas);
	}

	public List<ExpenseDatas> getDatabaseList() {
		List<ExpenseDatas> transactionList = Database.getInstance().getTransactionList();
		return transactionList;
	}

}
