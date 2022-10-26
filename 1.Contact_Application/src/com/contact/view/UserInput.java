package com.contact.view;

import java.util.Scanner;

import com.contact.controller.InputValidation;
import com.contact.controller.Process;

public class UserInput {
	Scanner scanner = new Scanner(System.in); 
	Process process;
	InputValidation validation;

	UserInput() {
		process = new Process();
		validation = new InputValidation();
	}

	protected void addContacts() {
		process.addNewContact(getName(), getMobileNumber());
		printMenu();
	}

	protected void modifyContact() {
		System.out.print(
				" Which one you want to change :\n\n  [1]Contact name\n "
				+ " [2]Contact Number\n Enter the choice: ");
		String option = getStringValue();
		if (option.equals("1")) {
			System.out.print("Enter existing contact name :");
			String query = "contact_name";
			process.updateContact(getName(), getName(),query);
			System.out.println("\n\t0 - To Main menu options.\n");
		} else if (option.equals("2")) {
			System.out.print(" Enter contact name & enter a new Mobile Number:\n");
			String query = "contact_number";
			process.updateContact(getName(), getMobileNumber(),query);
			printMenu();
		}
	}

	protected void removeContact() {
		System.out.print("Specify a contact to delete: ");
		process.removeContact(getStringValue());
		printMenu();
	}

	protected void findContact() {
        UserView view = new UserView();
		System.out.print("Type a contact name to find: ");
		view.searchContact(getStringValue().toLowerCase());
		printMenu();
	}

	protected void addFavourites() {
		System.out.print(
				"choose option: \n  [1]View favourite\n  [2]Add favourite\n  "
				+ "[3]Remove favourite\n Enter the option : ");
		String contactType = "", option = getStringValue();
		if (option.equals("1")) {
			UserView view = new UserView();
			contactType = "Favourite";
			view.searchFavourite(contactType);
		} else if (option.equals("2")) {
			System.out.print("Enter contact name to add in favourite: ");
			contactType = "Favourite";
			process.addFavourite(getStringValue(), contactType);

		} else if (option.equals("3")) {
			System.out.print("Enter contact name to remove in favourite: ");
			contactType = "null";
			process.addFavourite(getStringValue(), contactType);

		} else
			System.out.println("Enter valid option!!!");

		printMenu();
	}

	

	private String getMobileNumber() {
		boolean check;
		String mobileNumber;
		do {
			System.out.print("\nMobile no. : ");
			mobileNumber = getStringValue();
			check = validation.checkMobileNumber(mobileNumber);
			if (check == false)
				System.out.println("Invalid Mobile No!!");
		} while (check == false);
		return mobileNumber;
	}

	private String getName() {
		boolean check;
		String name;
		do {
			System.out.print("\nName : ");
			name = getStringValue();
			check = validation.checkName(name);
			if (check == false)
				System.out.println("Invalid Type!!");
		} while (check == false);
		return name;
	}
	
	private String getStringValue() {
		String input;
		do {
			input = scanner.nextLine();
		} while (input.equals(""));
		return input;
	}

	private void printMenu() {
		System.out.println("\n\t[0] - Back to Main menu options.\n");
	}
}
