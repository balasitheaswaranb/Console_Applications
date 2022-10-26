package com.expense.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
		private String url = "jdbc:mysql://localhost:3306/expense_manager";
		private String userName = "root";
		private String password = "Admin@123";
		public Connection connection;
		Statement statement;
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		
		protected Connection getConnection() {
			try {
				connection = DriverManager.getConnection(url, userName, password);
				return connection;
			} catch (SQLException e) {
				System.out.println("Error!!!" + e.getMessage());
			}
			return null;
		}
		
		protected void insertData(String sqlQuery) {
			try {
				connection = getConnection();
				preparedStatement = connection.prepareStatement(sqlQuery);
				int isInserted = preparedStatement.executeUpdate();
				if (isInserted == 1)
					System.out.println("Inserted");
				else
					System.out.println("Not inserted");
			} catch (SQLException e) {
				System.out.println("Error!!!" + e.getMessage());
			} finally {
				try {
					if (preparedStatement != null)
						preparedStatement.close();
				} catch (SQLException e) {
					System.out.println("Error!!!" + e.getMessage());
				}
				try {
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					System.out.println("Error!!!" + e.getMessage());
				}
			}
		}
		
		protected void getResultSet(String sqlQuery) {
			try {
				connection = getConnection();
				statement = connection.createStatement();
				resultSet = statement.executeQuery(sqlQuery);
			} catch (SQLException e) {
				System.out.println("Error!!!" + e.getMessage());
			}
		}
	}

	


