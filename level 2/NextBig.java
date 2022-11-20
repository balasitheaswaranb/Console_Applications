package com.dailylearning;

import java.util.Arrays;

public class NextBig {
	public static void main(String args[]) {
		new NextBig().init();
	}

	private void init() {
		int[] input1 = { 8, 4, 1, 9, 6, 2 };
		int[] input2 = input1.clone();
		Arrays.sort(input2);
		for (int i = 0; i < input1.length; i++) {
			for (int j = 0; j < input2.length; j++) {
				if (input1[i] == input2[j]) {
					if (j != input2.length - 1)
						System.out.print(input2[j + 1]);
					else
						System.out.print(input2[j]);
				}
			}
		}

	}
}
