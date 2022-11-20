package com.flight.view;

public class FlightApp {
	public static void main(String[] args) {
		new FlightApp().start();
	}

	private void start() {
		new LoginView().initLogin();
	}

}
