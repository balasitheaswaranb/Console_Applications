package com.expense.controller;

import java.util.List;

import com.expense.model.Database;
import com.expense.model.ExpenseDatas;
import com.expense.view.ManageExpense;

public class ExpenseController {
    ManageExpense manageExpense;
	ExpenseDatas expenseDatas;
	
	public void toAddTransaction() {
		
		expenseDatas = new ExpenseDatas();
		manageExpense = new ManageExpense();
		expenseDatas.setDate(manageExpense.getInput("Date of Transaction (DD/MM/YYYY) : ",
				"(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/][0-9]{4}"));
		expenseDatas.setKind(manageExpense.getInput("Kind (Income/Expense) : ", "Income|Expense|income|expense"));
		expenseDatas.setCategory(manageExpense.getInput("Category type : ", "[A-Za-z ]+"));
		expenseDatas.setAmount(Integer.valueOf(manageExpense.getInput("Amount : Rs.", "[0-9]+")));
		expenseDatas.setDescription(manageExpense.getInput("Additional Details : ", ".+"));
		Database.getInstance().insertTransaction(expenseDatas);
	}

	public List<ExpenseDatas> getDatabaseList() {
		List<ExpenseDatas> transactionList = Database.getInstance().getTransactionList();
		return transactionList;
	}

}
