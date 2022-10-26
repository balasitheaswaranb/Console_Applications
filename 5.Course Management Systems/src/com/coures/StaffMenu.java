package com.coures;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StaffMenu {
	Scanner scanner = new Scanner(System.in);
	StaffProcess staff = new StaffProcess();

	protected void staffMenu() {
		boolean isTrue = true;
		while (isTrue) {
			printStaffMenu();
			int selectedOption = 0;
			try {
				selectedOption = scanner.nextInt();
				switch (selectedOption) {
				case 1:
					System.out.print("Enter staff ID: ");
					int staffId = scanner.nextInt();
					if (staff.isInDatabase(staffId) == true) {
						System.out.println("\n          Modules List                 ");
						System.out.println("---------------------------------------");
						staff.displaySubjects();
						System.out.println("---------------------------------------");
					}
					break;

				case 2:
					System.out.print("Enter staff ID: ");
					int staffId1 = scanner.nextInt();
					if (staff.isInDatabase(staffId1) == true) {
						System.out.println("          Students List                 ");
						System.out.println("---------------------------------------");
						staff.displayStudentFromstaff();
						System.out.println("---------------------------------------");
					}
					break;

				case 3:
					System.out.print("Enter staff ID: ");
					int staffId2 = scanner.nextInt();
					if (staff.isInDatabase(staffId2) == true) {
						System.out.println("---------------------------------------");
						System.out.println("          Add Marks                 ");
						staff.addGrade();
						System.out.println("---------------------------------------");
					}
					break;

				case 4:
					MainMenu mainMenu = new MainMenu();
					mainMenu.initiate();
					break;

				case 5:
					System.out.println("Exiting the application...");
					System.exit(0);

				default:
					System.out.println("Error! Please input only the number options available above!!!");
					staffMenu();
				}
			} catch (InputMismatchException e) {
				scanner.next();
				System.out.println("Please input only the number options available above!!!");
				staffMenu();
			}
		}
	}

	private void printStaffMenu() {
		System.out.println("************************************");
		System.out.println("          Staff Menu                ");
		System.out.println("************************************");
		System.out.println("--------------------------------------");
		System.out.println("          1. View Subjects             ");
		System.out.println("          2. View Students             ");
		System.out.println("          3. Add Marks                 ");
		System.out.println("          4. Return to Main Menu       ");
		System.out.println("          5. Exit                      ");
		System.out.println("---------------------------------------");
		System.out.print("\nEnter Option: ");

	}
}
