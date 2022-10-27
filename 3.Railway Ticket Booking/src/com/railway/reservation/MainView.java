package com.railway.reservation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainView {
	Scanner scanner = new Scanner(System.in);
	PassengerDetail passengerDetail;
	TicketsList tickectList;
	Ticket ticket;
	
	public MainView() {
		passengerDetail = new PassengerDetail();
		tickectList = new TicketsList();
	}

	public void initiate() {
		boolean flag = true;
		while (flag) {
			try {
				printOptions();
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					bookTicket();
					break;
				case 2:
					cancelTicket();
					break;
				case 3:
					bookedTicketList();
					break;
				case 4:
					tickectList.availableTicketList();
					break;
				case 5:
					adminProcess();
					break;
				case 6:
					System.out.println("Thankyou Please visit again..!");
					flag = false;
					break;
				default:
					System.out.println("Please choose a valid choice.");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter valid integer input!!!");
				scanner.next();
			}
		}
		scanner.close();
	}

	private void adminProcess() {
		System.out.print("Enter your Admin ID : ");
		String adminID = scanner.next();
		System.out.print("Enter your Password : ");
		String password = scanner.next();
		if (Administrator.adminID.equals(adminID) && Administrator.adminID.equals(password)) {
			Administrator admin = new Administrator();
			admin.numberOfBerthAllocation();
		} else {
			System.out.println("Please enter a valid AdminID or Password.");
		}
	}

	private void bookedTicketList() {
		System.out.print("Enter your Admin ID : ");
		String adminID1 = scanner.next();
		System.out.print("Enter your Password : ");
		String password1 = scanner.next();
		if (Administrator.adminID.equals(adminID1) && Administrator.adminID.equals(password1)) {
			tickectList.bookedTicketList();
		} else {
			System.out.println("Please enter a valid AdminID or Password.");
		}
	}

	private void cancelTicket() {
		System.out.print("Enter your PNR Number : ");
		int pnrNumber = scanner.nextInt();
		if (Administrator.passengersList.containsKey(pnrNumber)) {

			ticket.cancelTicket(pnrNumber);
		} else {
			System.out.println("PNR Number is not found..!, Please Enter valid PNR Number.");
		}
	}

	private void bookTicket() {
		Passenger passenger = passengerDetail.passengerDetailCollecting();
		ticket = new Ticket();
		if (passenger != null) {
			ticket.bookTicket(passenger);
		} else {
		System.out.println("data not found");
		}
	}

	private void printOptions() {
		System.out.println("---------------------------------");
		System.out.println("1. Book Ticket.");
		System.out.println("2. Cancel Ticket.");
		System.out.println("3. Booked Tickets List.");
		System.out.println("4. Available Tickets List.");
		System.out.println("5. Are you admin please select 5.");
		System.out.println("6. Exit.");
		System.out.println("---------------------------------\n");
		System.out.print("Enter your choice : ");
	}

}