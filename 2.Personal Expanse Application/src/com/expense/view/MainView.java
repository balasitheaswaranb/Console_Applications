package com.expense.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.expense.controller.InputController;
import com.expense.model.Database;

public class MainView {
	Scanner scanner = new Scanner(System.in);
	ManageExpense manageExpense;
	InputController controller;
	
	MainView() {
		manageExpense = new ManageExpense();
		controller = new InputController();
	}

	protected void initiate() {
		checkForLogin();
		Database database = Database.getInstance();
		database.getDataFromDb();
		displayOptions();
	}

	private void displayOptions() {
		boolean isTrue = true;
		while (isTrue) {
			printOptions();
			try {
				String option = scanner.nextLine();
				switch (option) {
				case "1":
					manageExpense.addTransaction();
					break;
				case "2":
					manageExpense.viewAllExpense();
					break;
				case "3":
					manageExpense.searchTransaction();
					break;
				case "4":
					manageExpense.viewBalance();
					break;
				case "5":
					System.out.println("\nThank you!\n");
					isTrue = false;
				default:
					System.out.println("\nInvalid option.. Please choose again!\n");
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter the valid integer input!!!");
				scanner.next();
			}
		}
	}

	private void printOptions() {
		System.out.print("\n***********************\n1) Add Income or Expense Details \n2) View All Transaction\n3)"
				+ " Search Transaction\n4) View Balance	\n5) Exit	\n***********************\nEnter option..");
	}
	
	private void checkForLogin() {
		System.out.println("\nHii Sitheas please verify yourself!!! \n");
		System.out.print(" Enter User Name: ");
		String userName = scanner.nextLine();
		System.out.print(" Enter password: ");
		String password = scanner.nextLine();
		if (controller.checkCredentials(userName, password)) { 
			System.out.println("\n-->Welcome " + userName + "<--\n");
		} else {
			System.out.println("\nInvalid Credentials. Please try again!\n");
			checkForLogin();
		}
	} 
}