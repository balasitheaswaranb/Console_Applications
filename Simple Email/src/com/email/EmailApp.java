package com.email;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EmailApp {
	Scanner scanner = new Scanner(System.in);
	protected ArrayList<Email> Workers = new ArrayList<>();
    Database database = new Database();
	public static void main(String[] args) throws SQLException {

		new EmailApp().init();
	}

	private void init() {
		boolean isFinish = true;
		do {

			System.out.println("Welcome to Mail application for workers of our company");
			System.out.println("Please choose an action\n1-Log in our account \n2-Create your account\n3-Exit");
			LogInOrSignUp login = new LogInOrSignUp();
			int answer = login.scannerForAnswer(3);
			try {
			if (answer == 1) {
				System.out.println("Welcome to Email for workers!\nPlease enter your email and password");

				System.out.println("Email:");
				
				String userAnswerEmail = scanner.next();

				System.out.println("Password:");
				String userAnswerPassword = scanner.next();
				System.out.println("Just a second: we are checking you in our system ");
			
				int id = database.selectRecord(userAnswerEmail, userAnswerPassword);
				if (id != 0) {
					database.createAWorker(id);
				} else {
					System.out.println("Unfortunately this account does not exist");
				}

			} else if (answer == 2) {
				Email worker = new Email();
				System.out.println(worker.showInfo());
					database.insertRecord(worker.getFirstName(), worker.getLastName(), worker.getPassword(),
							worker.getEmail());
				
					PersonalAccount personal =new PersonalAccount();
					personal.account(worker);
				
			} else if (answer == 3) {
				isFinish = Finish();
			}
			}catch(Exception e) {
				System.out.println(e);
			}
		} while (isFinish);

	}


	public boolean Finish() {
		System.out.println("Do you want to finish (y/n)");
		char answer = scanner.next().charAt(0);
		return answer != 'y';
	}

}
