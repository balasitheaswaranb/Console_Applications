package com.hotel.controller;
import java.util.Scanner;

import com.hotel.model.DoubleRoom;
import com.hotel.model.Food;
import com.hotel.model.SingleRoom;

public class BookingController {
	Scanner scanner = new Scanner(System.in);
    private	DoubleRoom luxuryDoubleRooms[];
	private DoubleRoom deluxeDoubleRooms[];
	private SingleRoom luxurySingleRooms[];
	private SingleRoom deluxeSingleRooms[];

	public BookingController() {
		luxuryDoubleRooms = new DoubleRoom[10];
		deluxeDoubleRooms = new DoubleRoom[20];
		luxurySingleRooms = new SingleRoom[10];
		deluxeSingleRooms = new SingleRoom[20];
	}

	public DoubleRoom[] getLuxuryDoubleRooms() {
		return luxuryDoubleRooms;
		
	}
	public DoubleRoom[] getDeluxeDoubleRooms() {
		return deluxeDoubleRooms;
		
	}
	public SingleRoom[] getLuxurySingleRooms() {
		return luxurySingleRooms;
		
	}
	public SingleRoom[] getDeluxeSingleRooms() {
		return deluxeSingleRooms;
		
	}
	
	
	public int roomAvailabilityCount(int option) {
		int j, count = 0;
		switch (option) {
		case 1:
			for (j = 0; j < luxuryDoubleRooms.length; j++) {
				if (luxuryDoubleRooms[j] == null)
					count++;
			}
			break;
		case 2:
			for (j = 0; j < deluxeDoubleRooms.length; j++) {
				if (deluxeDoubleRooms[j] == null)
					count++;
			}
			break;
		case 3:
			for (j = 0; j < luxurySingleRooms.length; j++) {
				if (luxurySingleRooms[j] == null)
					count++;
			}
			break;
		case 4:
			for (j = 0; j < deluxeSingleRooms.length; j++) {
				if (deluxeSingleRooms[j] == null)
					count++;
			}
			break;
		default:
			System.out.println("Enter valid option");
			break;
		}
		return count;
	}
	

	public void getRoomNumber(int roomType) {
		int roomNumber, arrayIndex;
		System.out.println("\nChoose room number from : ");
		switch (roomType) {
		case 1:
			for (int j = 0; j < luxuryDoubleRooms.length; j++) {
				if (luxuryDoubleRooms[j] == null) {
					System.out.print(j + 1 + ",");
				}
			}
			
			System.out.print("\nEnter room number: ");
			try {
				roomNumber = scanner.nextInt();
				arrayIndex = roomNumber - 1;
				
				if (luxuryDoubleRooms[arrayIndex] == null)
				bookRoom(roomType, arrayIndex);
			} catch (Exception e) {
				System.out.println("Invalid Option");
				return;
			}
			break;
		case 2:
			for (int j = 0; j < deluxeDoubleRooms.length; j++) {
				if (deluxeDoubleRooms[j] == null) {
					System.out.print(j + 11 + ",");
				}
			}
			System.out.print("\nEnter room number: ");
			try {
				roomNumber = scanner.nextInt();
				arrayIndex = roomNumber - 1;
				
				if (luxuryDoubleRooms[arrayIndex] != null)
				bookRoom(roomType, arrayIndex);
			} catch (Exception e) {
				System.out.println("Invalid Option");
				return;
			}
			break;
		case 3:
			for (int j = 0; j < luxurySingleRooms.length; j++) {
				if (luxurySingleRooms[j] == null) {
					System.out.print(j + 31 + ",");
				}
			}
			System.out.print("\nEnter room number: ");
			try {
				roomNumber = scanner.nextInt();
				arrayIndex = roomNumber - 1;
				
				if (luxuryDoubleRooms[arrayIndex] == null)
				  bookRoom(roomType, arrayIndex);
			} catch (Exception e) {
				System.out.println("Invalid Option");
				return;
			}
			break;
		case 4:
			for (int j = 0; j < deluxeSingleRooms.length; j++) {
				if (deluxeSingleRooms[j] == null) {
					System.out.print(j + 41 + ",");
				}
			}
			System.out.print("\nEnter room number: ");
			try {
				roomNumber = scanner.nextInt();
				arrayIndex = roomNumber - 1;
				
				if (luxuryDoubleRooms[arrayIndex] != null)
				 bookRoom(roomType, arrayIndex);
			} catch (Exception e) {
				System.out.println("Invalid Option");
				return;
			}
			break;
		default:
			System.out.println("Enter valid option");
			break;
		}
		System.out.println("Room Booked");
	}
	public void bookRoom(int roomType, int arrayIndex) {
		String name, contact, gender;
		String name2 = null, contact2 = null;
		String gender2 = null;
		System.out.print("\nEnter customer name: ");
		name = scanner.next();
		System.out.print("Enter contact number: ");
		contact = scanner.next();
		System.out.print("Enter gender: ");
		gender = scanner.next();
		if (roomType < 3) {
			System.out.print("Enter second customer name: ");
			name2 = scanner.next();
			System.out.print("Enter contact number: ");
			contact2 = scanner.next();
			System.out.print("Enter gender: ");
			gender2 = scanner.next();
		}
		switch (roomType) {
		case 1:
			luxuryDoubleRooms[arrayIndex] = new DoubleRoom(name, contact, gender, name2, contact2, gender2);
			break;
		case 2:
			deluxeDoubleRooms[arrayIndex] = new DoubleRoom(name, contact, gender, name2, contact2, gender2);
			break;
		case 3:
			luxurySingleRooms[arrayIndex] = new SingleRoom(name, contact, gender);
			break;
		case 4:
			deluxeSingleRooms[arrayIndex] = new SingleRoom(name, contact, gender);
			
			break;
		}
	}

	public void orderFood(int RoomNumber, int roomType) {
		
		char wantMore;
		try {
			System.out.println("\n==========\n   Menu:  \n==========\n\n1.Idli\tRs.20"
					+ "\n2.Dosa\t\tRs.60\n3.Vadai\tRs.20\n4.Coffee\t\tRs.30\n");
			do {
				int chosenFood = scanner.nextInt();
				System.out.print("Quantity- ");
				int quantity = scanner.nextInt();

				switch (roomType) {
				case 1:
					luxuryDoubleRooms[RoomNumber].getFood().add(new Food(chosenFood, quantity));
					break;
				case 2:
					deluxeDoubleRooms[RoomNumber].getFood().add(new Food(chosenFood, quantity));
					break;
				case 3:
					luxurySingleRooms[RoomNumber].getFood().add(new Food(chosenFood, quantity));
					break;
				case 4:
					deluxeSingleRooms[RoomNumber].getFood().add(new Food(chosenFood, quantity));
					break;
				}
				System.out.println("Do you want to order anything else? (y/n)");
				wantMore = scanner.next().charAt(0);
			} while (wantMore == 'y' || wantMore == 'Y');
		} catch (NullPointerException e) {
			System.out.println("\nRoom not booked");
		}
	}

	public void vecateRoom(int roomNumber, int roomType) {
		char option;
		switch (roomType) {
		case 1:
			if (luxuryDoubleRooms[roomNumber] != null)
				System.out.println("Room used by " + luxuryDoubleRooms[roomNumber].getCustomerName());
			else {
				System.out.println("Empty Already");
				return;
			}
			System.out.println("Do you want to checkout ?(y/n)");
			option = scanner.next().charAt(0);
			if (option == 'y' || option == 'Y') {
				generateBill(roomNumber, roomType);
				luxuryDoubleRooms[roomNumber] = null;
				System.out.println("Deallocated succesfully");
			}
			break;
		case 2:
			if (deluxeDoubleRooms[roomNumber] != null)
				System.out.println("Room used by " + deluxeDoubleRooms[roomNumber].getCustomerName());
			else {
				System.out.println("Empty Already");
				return;
			}
			System.out.println(" Do you want to checkout ?(y/n)");
			option = scanner.next().charAt(0);
			if (option == 'y' || option == 'Y') {
				generateBill(roomNumber, roomType);
				deluxeDoubleRooms[roomNumber] = null;
			}
			break;
		case 3:
			if (luxurySingleRooms[roomNumber] != null)
				System.out.println("Room used by " + luxurySingleRooms[roomNumber].getCustomerName());
			else {
				System.out.println("Empty Already");
				return;
			}
			System.out.println(" Do you want to checkout ? (y/n)");
			option = scanner.next().charAt(0);
			if (option == 'y' || option == 'Y') {
				generateBill(roomNumber, roomType);
				luxurySingleRooms[roomNumber] = null;
			}
			break;
		case 4:
			if (deluxeSingleRooms[roomNumber] != null)
				System.out.println("Room used by " + deluxeSingleRooms[roomNumber].getCustomerName());
			else {
				System.out.println("Empty Already!");
				return;
			}
			System.out.println(" Do you want to checkout? (y/n)");
			option = scanner.next().charAt(0);
			if (option == 'y' || option == 'Y') {
				generateBill(roomNumber, roomType);
				deluxeSingleRooms[roomNumber] = null;
			}
			break;
		default:
			System.out.println("\nEnter a valid option : ");
			break;
		}
	}

	protected void generateBill(int roomNumber, int roomType) {

		double amount = 0;
		String list[] = { "idli", "Dosa", "Vadai", "Coffee" };
		System.out.println("\n*******");
		System.out.println(" Bill:-");
		System.out.println("*******");

		switch (roomType) {
		case 1:
			amount += 4000;
			System.out.println("\nRoom Charge - " + 4000);
			System.out.println("\n===============");
			System.out.println("Food Charges:- ");
			System.out.println("===============");
			System.out.println("Item   Quantity    Price");
			System.out.println("-------------------------");
			for (Food food : luxuryDoubleRooms[roomNumber].getFood()) {
				amount += food.getCost();
				System.out.println(
						list[food.getChosenFoodNo() - 1] + "   " + food.getQuantity() + "   " + food.getCost());
			}

			break;
		case 2:
			amount += 3000;
			System.out.println("Room Charge - " + 3000);
			System.out.println("\nFood Charges:- ");
			System.out.println("===============");
			System.out.println("Item   Quantity    Price");
			System.out.println("-------------------------");
			for (Food food : deluxeDoubleRooms[roomNumber].getFood()) {
				amount += food.getCost();
				System.out
						.println(list[food.getChosenFoodNo() - 1] + "  " + food.getQuantity() + "  " + food.getCost());
			}
			break;
		case 3:
			amount += 2200;
			System.out.println("Room Charge - " + 2200);
			System.out.println("\nFood Charges:- ");
			System.out.println("===============");
			System.out.println("Item   Quantity    Price");
			System.out.println("-------------------------");
			for (Food food : luxurySingleRooms[roomNumber].getFood()) {
				amount += food.getCost();
				String format = "%-10s%-10s%-10s%n";
				System.out.printf(format, list[food.getChosenFoodNo() - 1], food.getQuantity(), food.getCost());
			}
			break;
		case 4:
			amount += 1200;
			System.out.println("Room Charge - " + 1200);
			System.out.println("\nFood Charges:- ");
			System.out.println("===============");
			System.out.println("Item   Quantity    Price");
			System.out.println("-------------------------");
			for (Food food : deluxeSingleRooms[roomNumber].getFood()) {
				amount += food.getCost();
				System.out
						.println(list[food.getChosenFoodNo() - 1] + "  " + food.getQuantity() + "   " + food.getCost());
			}
			break;
		default:
			System.out.println("Not valid");
		}
		System.out.println("\nTotal Amount- " + amount);
	}

	
	
}