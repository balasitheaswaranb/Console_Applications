package com.hotel.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.hotel.controller.LoginController;

public class ShowServices {
	Scanner scanner = new Scanner(System.in);
	ManageRooms manageRooms;
	
	ShowServices() {
		manageRooms = new ManageRooms();
	}
	
	protected void initiate() {
		checkForLogin();
		try {
			char wantToContinue;
			do {
				printOptions();
				System.out.print("Enter the choice: ");
				int option = scanner.nextInt();
				switch (option) {
				case 1:
					manageRooms.showRoomDetails();
					break;
				case 2:
					manageRooms.showRoomAvailability();
					break;
				case 3:
					manageRooms.bookNewRoom();
					break;
				case 4:
					manageRooms.foodOrder();
					break;
				case 5:
					manageRooms.checkoutRoom();
					break;
				case 6:
					break;
				default:
					System.out.println("Invalid Option!");
				}
				System.out.println("\nContinue : (y/n)");
				wantToContinue = scanner.next().charAt(0);
				if (!(wantToContinue == 'y' || wantToContinue == 'Y' || wantToContinue == 'n'
						|| wantToContinue == 'N')) {
					System.out.println("Invalid Option!!!");
					System.out.println("\nContinue : (y/n)");
					wantToContinue = scanner.next().charAt(0);
				}
			} while (wantToContinue == 'y' || wantToContinue == 'Y');

		} catch (InputMismatchException e) {
			System.out.println("Not a valid input!!!");
			scanner.next();
		}
	}

	private void printOptions() {
		System.out.println("\nEnter Your Choice :\n1.Show Room Details\n"
				+ "2.Show Room Availability \n3.Book Room\n4.Order Food"
				+ "\n5.Checkout Now\n6.Quit\n");
	}

	private void checkForLogin() {
		System.out.println("Hii admin please verify yourself!!! \n");
		System.out.print("Enter User Name: ");
		String userName = scanner.next();
		System.out.print("\nEnter password: ");
		String password = scanner.next();
		LoginController loginController =new LoginController();
		if (loginController.checkCredentials(userName, password)) { 
			System.out.println("\n-->Welcome " + userName + "<--\n");
		} else {
			System.out.println("\nInvalid Credentials. Please try again!\n");
			checkForLogin();
		}
	}

	
	
}