package com.contact.view;

public class ContactApp {
	public static void main(String[] args) {
		ContactApp contact = new ContactApp();
		contact.start();
	}

	private void start() {
		MainView mainView = new MainView();
		mainView.initiate();
	}
}
