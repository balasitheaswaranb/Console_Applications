package com.hotel.view;

import java.util.Scanner;

import com.hotel.controller.BookingController;

public class ManageRooms {
	Scanner scanner = new Scanner(System.in);
	ReceptionistView receptionist = new ReceptionistView();
	BookingController booking =new BookingController();

	protected void showRoomDetails() {
		System.out.println("\nChoose Room Type :\n1.Luxury Double Bedroom \n2.Deluxe Double Bedroom"
				+ " \n3.Luxury Single Bedroom \n4.Deluxe Single Bedroom \n");
		int roomType = scanner.nextInt();
		receptionist.roomFeatures(roomType);
	}

	protected void showRoomAvailability() {
		System.out.println("\nChoose Room Type :\n1.Luxury Double Bedroom\n2.Deluxe Double Bedroom\n3."
				+ "Luxury Single Bedroom\n4.Deluxe Single Bedroom\n");
		int roomType = scanner.nextInt();
		receptionist.roomAvailability(roomType);
	}
	
	protected void checkoutRoom() {
		System.out.print("Room Number -");
		int roomNumber = scanner.nextInt();
		if (roomNumber > 60)
			System.out.println("Room doesn't exist");
		else if (roomNumber > 40)
			booking.vecateRoom(roomNumber - 41, 4);
		else if (roomNumber > 30)
			booking.vecateRoom(roomNumber - 31, 3);
		else if (roomNumber > 10)
			booking.vecateRoom(roomNumber - 11, 2);
		else if (roomNumber > 0)
			booking.vecateRoom(roomNumber - 1, 1);
		else
			System.out.println("Room doesn't exist");
	}

	protected void foodOrder() {
		System.out.print("Room Number -");
		int roomNumber = scanner.nextInt();
		if (roomNumber > 60)
			System.out.println("Room doesn't exist");
		else if (roomNumber > 40)
		       booking.orderFood(roomNumber - 41, 4);
		else if (roomNumber > 30)
			booking.orderFood(roomNumber - 31, 3);
		else if (roomNumber > 10)
			booking.orderFood(roomNumber - 11, 2);
		else if (roomNumber > 0)
			booking.orderFood(roomNumber - 1, 1);
		else
			System.out.println("Room doesn't exist");
	}

	protected void bookNewRoom() {
		System.out.println("\nChoose Room Type :\n1.Luxury Double Bedroom\n2.Deluxe Double Bedroom\n3"
				+ ".Luxury Single Bedroom\n4.Deluxe Single Bedroom\n");
		int roomType = scanner.nextInt();
		booking.getRoomNumber(roomType);
	}

	

}
