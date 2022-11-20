package com.dailylearning;

import java.util.ArrayList;
import java.util.Scanner;

public class PushSeven {
	public static void main(String args[]) {
		new PushSeven().toPush();
	}

	private void toPush() {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		int n = scanner.nextInt();
		int count = 0;
		while (n > 0) {
			int input = scanner.nextInt();
			if (input != 7) {
				list.add(input);
			} else {
				count++;
			}
			n--;
		}
		for (int i = 0; i < count; i++) {
			list.add(7);
		}
		System.out.print(list);
		scanner.close();
	}
}
