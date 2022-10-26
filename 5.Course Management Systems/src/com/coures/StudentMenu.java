package com.coures;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentMenu {
	Scanner scanner = new Scanner(System.in);
	StudentProcess studentProcess;

	StudentMenu() {
		studentProcess = new StudentProcess();
	}

	public void studentMenu() {
		boolean isTrue = true;
		while (isTrue) {
			printStudentOptionsMenu();
		int selectedOption = 0;
		try {
			selectedOption = scanner.nextInt();
			switch (selectedOption) {
			case 1:
				System.out.println("\n\n\n");
				enrolledStudentMenu();
				break;

			case 2:
				System.out.println("\n\n\n");
				studentProcess.enrollCourse();
				System.out.println("---------------------------------------");
				break;

			case 3:
				System.out.println("\n\n\n");
				isTrue = false;
				break;

			case 4:
				System.out.println("Exiting the application...");
				System.exit(0);

			default:
				System.out.println("Error! Please input only the number options available above!!!");
				System.out.println("\n\n");
				studentMenu();
			}
		} catch (InputMismatchException e) {
			scanner.next();
			System.out.println("Please input only the number options available above!!!");
			studentMenu();
		}
		}
	}

	private void enrolledStudentMenu() {
		printOptionsEntrolledStudent();
		int selectedOption = 0;
		try {
			selectedOption = scanner.nextInt();
			switch (selectedOption) {
			case 1:
				System.out.print("Enter student ID: ");
				int studentId = scanner.nextInt();
				if (studentProcess.isInDatabase(studentId)) {
					System.out.println("---------------------------------------");
					System.out.println("              Staff List          ");
					System.out.println("---------------------------------------");
					studentProcess.displayStaffsOnStudent();
				} else {
					System.out.println("Student ID doesn't exist!!");
					studentMenu();
				}
				break;

			case 2:
				studentMenu();
				break;

			case 3:
				MainMenu main = new MainMenu();
				main.initiate();
				break;

			case 4:
				System.out.println("Exiting the application...");
				System.exit(0);

			default:
				System.out.println("Error! Please input only the number options available above!!!");
				enrolledStudentMenu();
			}
		} catch (InputMismatchException e) {
			scanner.next();
			System.out.println("Please input only the number options available above!!!");
			enrolledStudentMenu();
		}
	}

	private void printStudentOptionsMenu() {

		System.out.println("************************************");
		System.out.println("         Student Menu                ");
		System.out.println("************************************\n");
		System.out.println("Are you enrolled?");
		System.out.println("--------------------------------------\n");
		System.out.println("1. Yes");
		System.out.println("2. No");
		System.out.println("3. Return to Main menu");
		System.out.println("4. Exit");
		System.out.println("--------------------------------------");
		System.out.print("\nEnter Option: ");

	}

	private void printOptionsEntrolledStudent() {
		System.out.println("************************************");
		System.out.println("     Enrolled Student Menu          ");
		System.out.println("************************************\n");
		System.out.println("--------------------------------------");
		System.out.println("        1. View Staffs           ");
		System.out.println("        2. Return to Student Menu     ");
		System.out.println("        3. Return to Main Menu        ");
		System.out.println("        4. Exit                       ");
		System.out.println("--------------------------------------");
		System.out.print("\nEnter Option: ");

	}
}
