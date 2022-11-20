package com.dailylearning;

public class Frequency {
	public static void main(String args[]) {
		new Frequency().init();
	}

	private void init() {
		String str = "aaabbcdd";
		findFreq(str);
	}

	private void findFreq(String str) {
		for (int i = 0; i < str.length(); i++) {
			int count = 1;
			int j = i + 1;
			while (str.charAt(i) == str.charAt(j)) {
				count++;
				str = str.substring(0, j) + str.substring(j + 1);
				j--;
			}
			if (count > 1)
				System.out.print(String.valueOf(str.charAt(i)) + count);
			else
				System.out.print(String.valueOf(str.charAt(i)));

		}
	}
}
