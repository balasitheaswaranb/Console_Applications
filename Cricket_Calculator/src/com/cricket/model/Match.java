package com.cricket.model;

public class Match {
	private static Match match;
	Innings firstInnings, secondInnings;

	private Match() {
		firstInnings = new Innings();
		secondInnings = new Innings();
	}

	public static Match getInstance() {
		if (match == null) {
			match = new Match();
		}
		return match;
	}

	public Innings getFirstInnings() {
		return firstInnings;
	}

	public Innings getSecondInnings() {
		return secondInnings;
	}
}
