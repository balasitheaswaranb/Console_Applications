package com.expense.controller;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputController {
		 Scanner scan = new Scanner(System.in);
		 
		public String getInput(String field, String regex) {
			String input;
			System.out.print("\nEnter " + field);
			input = scan.nextLine();
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(input);
			if (matcher.matches())
				return input;
			else {
				System.out.println("Invalid input!!");
				return getInput(field, regex);
			}
		}

		public boolean checkCredentials(String userName, String password) {	
			return userName.equals("admin") && password.equals("12345");
		}
	}

