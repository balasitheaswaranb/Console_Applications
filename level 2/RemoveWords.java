package com.dailylearning;

import java.util.Scanner;

public class RemoveWords {
	public static void main(String args[]) {
		new RemoveWords().init();
	}

	private void init() {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String[] separatedInput = input.split(" ");
		String[] reversedInput = new String[input.length()];
		for (int i = 0; i < separatedInput.length; i++) {
			StringBuilder str = new StringBuilder(separatedInput[i]);
			str.reverse();
			reversedInput[i] = str.toString();
		}
		for (int i = 0; i < separatedInput.length; i++) {
			if (separatedInput[i].equals(reversedInput[i])) {
				separatedInput[i] = "";
			}
		}
		for (String i : separatedInput) {
			System.out.print(i + " ");
		}
		scanner.close();
	}
}
