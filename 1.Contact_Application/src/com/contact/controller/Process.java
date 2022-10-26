package com.contact.controller;

import java.util.ArrayList;
import java.util.Iterator;

import com.contact.model.ContactDetails;
import com.contact.model.Database;

public class Process {
    ContactDetails contactdetails;
	Database database = Database.getInstance();



	public void addNewContact(String name, String mobileNumber) {
		ContactDetails resultLoop = iterateContacts(name);
		if (resultLoop != null) {
			System.out.println("There is a contact with this name: " + name);
			System.out.println("Please try to use different contact name.");
		} else {
			contactdetails = new ContactDetails();
			contactdetails.setName(name);
			contactdetails.setPhoneNumber(mobileNumber);
			database.insertNewContact(contactdetails);
		}
	}

	public void updateContact(String ContactName, String ContactNameOrNumber,String query) {

		ContactDetails resultLoop = iterateContacts(ContactName);
		if (resultLoop != null) {
			database.updateContact(ContactName,ContactNameOrNumber,query);
		} else {
			System.out.println("There is no contact with this " + ContactName + " contact name.");
			System.out.println("Please try to add a new contact!");
		}
	}

	
	public void removeContact(String contactName) {
		ContactDetails resultLoop = iterateContacts(contactName);
		if (resultLoop != null) {
			database.removeContact(resultLoop.getName());
			System.out.println(resultLoop.getName() + " -> this contact was deleted.");
		} else {
			System.out.println("This contact doesn't exist.");
		}
	}

	

	public void addFavourite(String contactName, String contactType) {
		ContactDetails resultLoop = iterateContacts(contactName);
		if (resultLoop != null) {
        	database.addfavourite(contactName, contactType);
		} else {
			System.out.println("There is no contact with this " + contactName + " contact name.");
			System.out.println("Please try to add a new contact!");
		}
	}
	
	private ContactDetails iterateContacts(String name) {
		Iterator<ContactDetails> contactsIterator = getContactsArrayList().iterator();
		while (contactsIterator.hasNext()) {
			ContactDetails currentContact = contactsIterator.next();
			if (currentContact.getName().equals(name)) {
				return currentContact;
			}
		}
		return null;
	}
	
	public ArrayList<ContactDetails> getContactsArrayList() {
		return database.getdbArrayList();
		
	}
	
}
