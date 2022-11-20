package com.dailylearning;

import java.util.HashMap;
import java.util.Scanner;

public class NokiaKeypad {
	public static void main(String args[]) {
		new NokiaKeypad().init();
	}

	private void init() {
		Scanner scanner = new Scanner(System.in);
		HashMap<Integer, String> keys = new HashMap<>();
		keys.put(2, "abc");
		keys.put(3, "def");
		keys.put(4, "ghi");
		keys.put(5, "jkl");
		keys.put(6, "mno");
		keys.put(7, "pqrs");
		keys.put(8, "tuv");
		keys.put(9, "wxyz");
		keys.put(0, " ");
		String input = scanner.nextLine();
		String inputValue = "";
		boolean isCaps = false;
		if (input.charAt(0) == '#') {
			inputValue = input.substring(1);
			isCaps = true;
		} else {
			inputValue = input;
		}
		String[] separatedInput = inputValue.split("-");
		for (int i = 0; i < separatedInput.length; i++) {
			String letters = keys.get((separatedInput[i].charAt(0) - '0'));
			if (isCaps) {
				System.out.print((char) (letters.charAt(separatedInput[i].length() - 1) - 32));
			} else {
				System.out.print(letters.charAt(separatedInput[i].length() - 1));
			}
		}
		scanner.close();
	}
}
