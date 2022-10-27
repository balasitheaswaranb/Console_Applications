package com.contact.model;

import java.sql.SQLException;
import java.util.ArrayList;

public class Database {
	static Database database;
	private ArrayList<ContactDetails> dbArrayList;
	DatabaseConnection databaseConnection;
	ContactDetails newContact;

	private Database() {
		dbArrayList = new ArrayList<>();
		databaseConnection = new DatabaseConnection();
	}

	public static Database getInstance() {
		if (database == null) {
			database = new Database();
		}
		return database;
	}
	
	public ArrayList<ContactDetails> getdbArrayList() {
		return dbArrayList;

	}

	public void insertNewContact(ContactDetails contactDetails) {
		this.dbArrayList.add(contactDetails);
		String sqlQuery = "INSERT INTO contacts_table" + "(contact_name,contact_number)" + "values(" + "'"
				+ contactDetails.getName() + "','" + contactDetails.getPhoneNumber() + "')";
		databaseConnection.insertData(sqlQuery);

	}

	
	public void getDataFromDb() {
		try {
			String sqlQuery = "SELECT * FROM contacts_table";
			databaseConnection.getResultSet(sqlQuery);
			if (dbArrayList.size() == 0) {
				while (databaseConnection.resultSet.next()) {
					newContact = new ContactDetails();
					newContact.setName(databaseConnection.resultSet.getString("contact_name"));
					newContact.setPhoneNumber(databaseConnection.resultSet.getString("contact_number"));
					newContact.setContactType(databaseConnection.resultSet.getString("contact_type"));
					dbArrayList.add(newContact);
				}
			} else {
				dbArrayList.removeAll(dbArrayList);
				while (databaseConnection.resultSet.next()) {
					newContact = new ContactDetails();
					newContact.setName(databaseConnection.resultSet.getString("contact_name"));
					newContact.setPhoneNumber(databaseConnection.resultSet.getString("contact_number"));
					newContact.setContactType(databaseConnection.resultSet.getString("contact_type"));
					dbArrayList.add(newContact);
				}
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void updateContact(String ContactName, String ContactNameOrNumber, String query) {
		String sqlUpdateQuery = "update contacts_table set " + query + " = '" + ContactNameOrNumber
				+ "' where contact_name = '" + ContactName + "'";
		databaseConnection.insertData(sqlUpdateQuery);
		getDataFromDb();

	}

	public void removeContact(String contactName) {
		String sqlRemoveQuery = "delete from contacts_table where contact_name = '" + contactName + "'";
		databaseConnection.insertData(sqlRemoveQuery);
		getDataFromDb();
	}

	public void addfavourite(String contactName, String contactType) {
		String sqlUpdateQuery = "update contacts_table set contact_type = '" + contactType + "' where contact_name = '"
				+ contactName + "'";
		databaseConnection.insertData(sqlUpdateQuery);
		getDataFromDb();
	}
}
