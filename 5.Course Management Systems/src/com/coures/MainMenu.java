package com.coures;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
	Scanner scanner;
	StudentMenu studentMenu;
	StaffMenu staffMenu;
	AdminMenu adminMenu;
	MainMenu(){
		scanner = new Scanner(System.in);
		studentMenu = new StudentMenu();
		staffMenu = new StaffMenu();
		adminMenu = new AdminMenu();
	}

	public void initiate() {
		boolean repeat = true;
		while(repeat) {
		printMenuOptions();
		int selectedOption = 0;
		try {
			selectedOption = scanner.nextInt();
			switch (selectedOption) {
			case 1:
				System.out.println("\n\n\n");
				studentMenu.studentMenu();
				break;

			case 2:
				System.out.println("\n\n\n");
				staffMenu.staffMenu();
				break;

			case 3:
				System.out.println("\n\n\n");
				adminMenu.adminMenu();
				break;

			case 4:
				repeat = false;
				System.out.println("Exiting the application...");
				

			default:
				System.out.println("Error! Please input only the number options available above!!!");
				initiate();
			}
		} catch (InputMismatchException e) {
			scanner.next();
			System.out.println("Please input only the number options available above!!!");
		    initiate();
		}
		}
	}

	private void printMenuOptions() {
		System.out.println("************************************");
		System.out.println("  Welcome to course management app  ");
		System.out.println("************************************\n");
		System.out.println("What is your role?\n");
		System.out.println("--------------------------------------");
		System.out.println("          1. Student                   ");
		System.out.println("          2. Staff                     ");
		System.out.println("          3. Course Administrator      ");
		System.out.println("          4. Exit                      ");
		System.out.println("---------------------------------------");
		System.out.print("\nEnter Option: ");

	}

}