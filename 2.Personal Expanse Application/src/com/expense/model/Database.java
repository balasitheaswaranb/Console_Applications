package com.expense.model;
import java.util.ArrayList;
import java.util.List;

public class Database {
	private static Database database;
	private List<ExpenseDatas> transactionList; 
	DatabaseConnection databaseConnection;

	private Database() {
		transactionList = new ArrayList<ExpenseDatas>();
		databaseConnection = new DatabaseConnection();

	}

	public List<ExpenseDatas> getTransactionList() {
		return transactionList;
	}

	public void insertTransaction(ExpenseDatas expenseDatas) {
		this.transactionList.add(expenseDatas);
		databaseConnection.insertData("Insert into expense_table values ('" + expenseDatas.getDate() + "' , '"
				+ expenseDatas.getCategory() + "' , '" + expenseDatas.getKind() + "' , " + expenseDatas.getAmount()
				+ " , '" + expenseDatas.getDescription() + "')");
	}	

	public void getDataFromDb() {
		try {
			String sqlQuery = "Select * from expense_table";
			databaseConnection.getResultSet(sqlQuery);
			ExpenseDatas expenseDatas;
			while (databaseConnection.resultSet.next()) {
				expenseDatas = new ExpenseDatas();
				expenseDatas.setDate(databaseConnection.resultSet.getString(1));
				expenseDatas.setCategory(databaseConnection.resultSet.getString(2));
				expenseDatas.setKind(databaseConnection.resultSet.getString(3));
				expenseDatas.setAmount(databaseConnection.resultSet.getInt(4));
				expenseDatas.setDescription(databaseConnection.resultSet.getString(5));
				transactionList.add(expenseDatas);
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
