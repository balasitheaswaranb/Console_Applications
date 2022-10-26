package com.coures;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	private String url = "jdbc:mysql://localhost:3306/course_management";
	private String userName = "root";
	private String password = "Admin@123";
	static Database database;
	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	private Database() {
	}

	protected Connection getConnection() {
		try {
			connection = DriverManager.getConnection(url, userName, password);
			return connection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	protected boolean insertIntoDatabase(String sqlQuery) {
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sqlQuery);
			int isInserted = preparedStatement.executeUpdate();
			if (isInserted == 1)
				return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public void resultSet(String sqlQuery) {
		try {
			connection = getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
		} catch (SQLException ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}

	protected static Database getInstance() {
		if (database == null) {
			database = new Database();
		}
		return database;
	}
}
