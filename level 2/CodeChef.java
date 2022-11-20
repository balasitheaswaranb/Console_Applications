package com.dailylearning;

import java.util.Scanner;

public class CodeChef {

	public static void main(String[] args){
		new CodeChef().init();
	}

	private void init() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		while (n-- > 0) {
			String str = scanner.next();
			int j=0;
			for (int i = 0; i <str.length(); i++) {
				if(str.charAt(i)==str.charAt(str.length()-1-j)) {
					j++;
				}
			}
			System.out.println(str.length()-j);
		}
		scanner.close();
	}

}
