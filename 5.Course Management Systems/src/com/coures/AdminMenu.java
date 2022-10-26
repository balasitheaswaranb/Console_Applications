package com.coures;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminMenu {
	Scanner scanner = new Scanner(System.in);
	AdminProcess admin = new AdminProcess();
	Courses course = new Courses();

	protected void adminMenu() {

		PrintAdminOptions();
		int selectedOption = 0;
		try {
			selectedOption = scanner.nextInt();
			switch (selectedOption) {
			case 1:
				System.out.println("---------------------------------------");
				System.out.println("          Admin Login                   ");
				System.out.println("---------------------------------------");
				if (admin.adminLogin() == true) {
					System.out.println("login successful....");
					adminLoggedInMenu();
				} else {
					adminMenu();
				}
				break;

			case 2:
				MainMenu mainMenu = new MainMenu();
				mainMenu.initiate();
				break;

			case 3:
				System.out.println("Exiting the application...");
				System.exit(0);

			default:
				System.out.println("Error! Please input only the number options available above!!!");
				adminMenu();
			}
		} catch (InputMismatchException e) {
			scanner.next();
			System.out.println("Please input only the number options available above!!!");
			adminMenu();
		}
	}

	private void adminLoggedInMenu() {
		boolean isTrue = true;
		while (isTrue) {
			printAdminLoginOptions();
			int selectedOption = 0;
			try {
				selectedOption = scanner.nextInt();
				switch (selectedOption) {
				case 1:
					System.out.println("--------------------------------------");
					System.out.println("        Add New Course                ");
					System.out.println("--------------------------------------");
					course.addCourse();
					System.out.println("--------------------------------------");
					break;

				case 2:
					System.out.println("\n\n\n");
					System.out.println("--------------------------------------");
					System.out.println("          Add New Subject              ");
					System.out.println("--------------------------------------");
					admin.addSubject();
					System.out.println("--------------------------------------");
					break;

				case 3:
					System.out.println("--------------------------------------");
					System.out.println("           Delete Course              ");
					System.out.println("--------------------------------------");
					course.deleteCourse();
					System.out.println("--------------------------------------");
					break;

				case 4:
					System.out.println("--------------------------------------");
					System.out.println("           Update Course              ");
					System.out.println("--------------------------------------");
					admin.editCourse();
					System.out.println();
					System.out.println("--------------------------------------");
					break;

				case 5:
					System.out.println("--------------------------------------");
					System.out.println("            Update Subject            ");
					System.out.println("--------------------------------------");
					admin.editSubjects();
					System.out.println("--------------------------------------");
					break;

				case 6:
					System.out.println("--------------------------------------");
					System.out.println("       Add New Staff                  ");
					System.out.println("--------------------------------------");
					admin.assignNewStaff();
					System.out.println("--------------------------------------");
					break;

				case 7:
					System.out.println("--------------------------------------");
					System.out.println("        Assign Staff                  ");
					System.out.println("--------------------------------------");
					admin.assignStaffToCourse();
					System.out.println("--------------------------------------");
					break;

				case 8:
					System.out.println("--------------------------------------");
					System.out.println("            Cancel Course             ");
					System.out.println("--------------------------------------");
					admin.cancelCourse();
					System.out.println("--------------------------------------");
					break;

				case 9:
					System.out.println("--------------------------------------");
					System.out.println("          Resume Course               ");
					System.out.println("--------------------------------------");
					admin.resumeCourse();
					System.out.println();
					System.out.println("--------------------------------------");
					break;

				case 10:
					System.out.println("--------------------------------------");
					System.out.println("       Update Staff                   ");
					System.out.println("--------------------------------------");
					admin.updateStaff();
					System.out.println("--------------------------------------");
					break;

				case 11:
					admin.resultSlip();
					break;

				case 12:
					adminMenu();
					break;

				case 13:
					MainMenu mainMenu = new MainMenu();
					mainMenu.initiate();
					break;

				case 14:
					System.out.println("Exiting the application...");
					isTrue = false;
					System.exit(0);

				default:
					System.out.println("Error! Please input only the number options available above!!!");
					adminLoggedInMenu();
				}
			} catch (InputMismatchException e) {
				scanner.next();
				System.out.println("Please input only the number options available above!!!");
				adminLoggedInMenu();
			}
		}
	}

	private void printAdminLoginOptions() {
		System.out.println("************************************");
		System.out.println("          Admin Panel               ");
		System.out.println("************************************");
		System.out.println("--------------------------------------");
		System.out.println("          1. Add Course               ");
		System.out.println("          2. Add Subject              ");
		System.out.println("          3. Delete Course            ");
		System.out.println("          4. Edit Course              ");
		System.out.println("          5. Edit Subject             ");
		System.out.println("          6. Add New Staff            ");
		System.out.println("          7. Assign Staff             ");
		System.out.println("          8. Cancel Course            ");
		System.out.println("          9. Resume Course            ");
		System.out.println("          10. Update Staff            ");
		System.out.println("          11. Generate Result Report  ");
		System.out.println("          12. Log Out                 ");
		System.out.println("          13. Return to Main menu     ");
		System.out.println("          14. Exit                    ");
		System.out.println("---------------------------------------");
		System.out.print("\nEnter Option: ");

	}

	private void PrintAdminOptions() {
		System.out.println("************************************");
		System.out.println("          Admin Menu                ");
		System.out.println("************************************");
		System.out.println("--------------------------------------");
		System.out.println("          1. Log In                   ");
		System.out.println("          2. Return to Main Menu       ");
		System.out.println("          3. Exit                      ");
		System.out.println("---------------------------------------");
		System.out.print("\nEnter Option: ");

	}
}
