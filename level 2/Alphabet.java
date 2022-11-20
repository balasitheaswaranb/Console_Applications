package com.dailylearning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Alphabet {
	public static void main(String args[]) {
		new Alphabet().init();
	}

	private void init() {
		String GivenString = "a10b10";
		List<String> CharacterList = new ArrayList<>(Arrays.asList(GivenString.split("[0-99]")));
		List<String> NumberList = new ArrayList<>(Arrays.asList(GivenString.split("[a-z]")));
		CharacterList.removeIf(Character -> (Character.isEmpty()));
		NumberList.removeIf(Number -> (Number.isEmpty()));

		printChar(CharacterList, NumberList);
	}

	void printChar(List<String> CharacterList, List<String> NumberList) {
		for (int i = 0; i < CharacterList.size(); i++) {
			for (int j = 0; j < Integer.valueOf(NumberList.get(i)); j++) {
				System.out.print(CharacterList.get(i));
			}
			System.out.println();
		}

	}
}