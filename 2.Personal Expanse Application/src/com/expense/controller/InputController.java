package com.expense.controller;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.expense.view.ManageExpense;

public class InputController {
		 Scanner scan = new Scanner(System.in);
		 
		public String checkInput(String input,String field, String regex) {
			
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(input);
			if (matcher.matches())
				return input;
			else {
				System.out.println("Invalid input!!");
				return new ManageExpense().getInput(field,regex);
			}
		}

		public boolean checkCredentials(String userName, String password) {	
			return userName.equals("admin") && password.equals("12345");
		}
	}

