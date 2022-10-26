package com.contact.view;

import java.util.Iterator;

import com.contact.controller.Process;
import com.contact.model.ContactDetails;

public class UserView {
	Process process;
UserView(){
	process = new Process();
}

	public void printAllContacts() {
		Process process = new Process();
		Iterator<ContactDetails> contactsIterator = process.getContactsArrayList().iterator();
		while (contactsIterator.hasNext()) {
			ContactDetails nextContact = contactsIterator.next();
			System.out.println((process.getContactsArrayList().indexOf(nextContact) + 1) + ". Contact name: "
					+ nextContact.getName() + ", Mobile number: " + nextContact.getPhoneNumber() + "\n");
		}
		checkIsEmpty();
		printMenu();
	}

	private void checkIsEmpty() {
		if (process.getContactsArrayList().size() == 0) {
			System.out.println("The contact list is empty.");
		}
	}

	private void printMenu() {
		System.out.println("\n\t[0] - Back to Main menu options.\n");
	}

	public void searchContact(String contactName) {
		Iterator<ContactDetails> contactsIterator = process.getContactsArrayList().iterator();
		int count = 0;
		while (contactsIterator.hasNext()) {
			ContactDetails currentContact = contactsIterator.next();
			String contactNameToLower =currentContact.getName().toLowerCase();
			if (contactNameToLower.startsWith(contactName)) {
				System.out.println("Name: " + currentContact.getName() + " ,  " + "Mobile number: "
						+ currentContact.getPhoneNumber() + "\n");
				count++;
			}
		}
		if (count == 0) {
			System.out.println("  No contacts found!!!");
		}
	}

	public void searchFavourite(String contactType) {

		Iterator<ContactDetails> contactsIterator = process.getContactsArrayList().iterator();
		int count = 0;
		while (contactsIterator.hasNext()) {
			ContactDetails currentContact = contactsIterator.next();
			if (currentContact.getContactType().equals(contactType)) {
				System.out.println(
						"Name: " + currentContact.getName() + ",  Mobile number: " + currentContact.getPhoneNumber());
				count++;
			}
		}
		if (count == 0) {
			System.out.println("  No such a type of favourite contacts!!!");
		}
	}
}
