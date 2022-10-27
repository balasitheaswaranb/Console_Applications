package com.hotel.view;

public class HotelApp {
	private ShowServices menuView = new ShowServices();

	public static void main(String[] args) {
		HotelApp hotelApp = new HotelApp();
		hotelApp.start();
	}

	private void start() {
		System.out.println("Welcome to Hotel Management System\n --------------------------------");
        menuView.initiate();
	}

}