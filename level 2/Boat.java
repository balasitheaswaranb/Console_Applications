package com.dailylearning;

import java.util.Arrays;

public class Boat {
	public static void main(String args[]) {
		new Boat().init();
	}

	private void init() {
		int[] arr = { 1, 2, 3, 2, 3, 1, 1 };
		int k = 3;
		toAllotBoats(arr, k);
	}

	private void toAllotBoats(int[] arr, int k) {
		Arrays.sort(arr);
		int left = 0;
		int right = arr.length - 1;
		int boatCount = 0;
		while (left <= right) {
			boatCount += 1;
			if (left + right <= k)
				left += 1;
			right -= 1;
		}
		System.out.println(boatCount);
	}
}
