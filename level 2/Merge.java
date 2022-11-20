package com.dailylearning;

import java.util.Arrays;
import java.util.TreeSet;

public class Merge {
	public static void main(String args[]) {
		new Merge().init();
	}

	private void init() {
		Integer[] array1 = { 1, 3, 5, 7, 9 };
		Integer[] array2 = { 1, 2, 3, 4, 5, 6, 7, 8, 10 };
		TreeSet<Integer> set = new TreeSet<>();
		set.addAll(Arrays.asList(array1));
		set.addAll(Arrays.asList(array2));
		for (Integer i : set) {
			System.out.print(i);
		}
	}
}
