package com.view;

import java.util.Scanner;

import com.controller.BookingController;

public class ReceptionistView {
	Scanner scanner = new Scanner(System.in);
	BookingController booking = new BookingController();
	
	protected void roomFeatures(int option) {
		switch (option) {
		case 1:
			System.out.println("Number of double beds : 1\nAC :" + " Yes\nFree breakfast : Yes\nCharge per day:4000 ");
			break;
		case 2:
			System.out.println("Number of double beds : 1\nAC :" + " No\nFree breakfast : Yes\nCharge per day:3000  ");
			break;
		case 3:
			System.out.println("Number of single beds : 1\nAC :" + " Yes\nFree breakfast : Yes\nCharge per day:2200  ");
			break;
		case 4:
			System.out.println("Number of single beds : 1\nAC :" + " No\nFree breakfast : Yes\nCharge per day:1200 ");
			break;
		default:
			System.out.println("Enter valid option");
			break;
		}
	}
	protected void roomAvailability(int option) {
		BookingController booking = new BookingController();
		System.out.println("Number of rooms available : " + booking.roomAvailabilityCount(option));
	}
	
	

	
}
