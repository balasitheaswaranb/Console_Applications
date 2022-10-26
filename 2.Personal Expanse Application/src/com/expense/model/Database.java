package com.expense.model;
import java.util.ArrayList;
import java.util.List;

public class Database {
	private static Database database;
	private List<ExpenseData> transactionList; 
	DatabaseConnection databaseConnection;

	private Database() {
		transactionList = new ArrayList<ExpenseData>();
		databaseConnection = new DatabaseConnection();

	}

	public List<ExpenseData> getTransactionList() {
		return transactionList;
	}

	public void insertTransaction(ExpenseData expenseData) {
		this.transactionList.add(expenseData);
		databaseConnection.insertData("Insert into expense_table values ('" + expenseData.getDate() + "' , '"
				+ expenseData.getCategory() + "' , '" + expenseData.getKind() + "' , " + expenseData.getAmount()
				+ " , '" + expenseData.getDescription() + "')");
	}	

	public void getDataFromDb() {
		try {
			String sqlQuery = "Select * from expense_table";
			databaseConnection.getResultSet(sqlQuery);
			ExpenseData expenseData;
			while (databaseConnection.resultSet.next()) {
				expenseData = new ExpenseData();
				expenseData.setDate(databaseConnection.resultSet.getString(1));
				expenseData.setCategory(databaseConnection.resultSet.getString(2));
				expenseData.setKind(databaseConnection.resultSet.getString(3));
				expenseData.setAmount(databaseConnection.resultSet.getInt(4));
				expenseData.setDescription(databaseConnection.resultSet.getString(5));
				transactionList.add(expenseData);
			}
		} catch (Exception e) {
			System.out.println("Error!!!" + e.getMessage());
		}

	}

	public static Database getInstance() {
		if (database == null) {
			database = new Database();
		}
		return database;
	}
}
