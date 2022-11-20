package com.dailylearning;

import java.util.Arrays;
import java.util.Scanner;

public class Beautiful {
	public static void main(String args[]) {
		new Beautiful().init();
	}

	private void init() {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		char inputArray[] = input.toCharArray();
		int[] intArray1 = new int[inputArray.length];

		StringBuilder stringBuilder = new StringBuilder(input);
		stringBuilder.reverse();
		String reversedString = stringBuilder.toString();
		char reversedArray[] = reversedString.toCharArray();
		int[] intArray2 = new int[reversedArray.length];

		for (int i = 0; i < inputArray.length; i++) {
			intArray1[i] = inputArray[i];
		}
		for (int i = 0; i < reversedArray.length; i++) {
			intArray2[i] = reversedArray[i];
		}
		int count1[] = new int[intArray1.length - 1];
		for (int i = 0; i < intArray1.length - 1; i++) {
			count1[i] = intArray1[i + 1] - intArray1[i];
		}
		int count2[] = new int[intArray2.length - 1];
		for (int i = 0; i < intArray2.length - 1; i++) {
			count2[i] = intArray2[i] - intArray2[i + 1];
		}
		Arrays.sort(count1);
		Arrays.sort(count2);
		if (Arrays.equals(count1, count2)) {
			System.out.println("Yes");
		} else
			System.out.println("no");
		scanner.close();
	}
}
