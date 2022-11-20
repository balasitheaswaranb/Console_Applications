package com.cricket.model;

public class Innings {
	private Team battingTeam = new Team();
	private Team bowlingTeam = new Team();
	private int extras;

	public Team getBattingTeam() {
		return battingTeam;
	}

	public void setBattingTeam(Team battingTeam) {
		this.battingTeam = battingTeam;
	}

	public Team getBowlingTeam() {
		return bowlingTeam;
	}

	public void setBowlingTeam(Team bowlingTeam) {
		this.bowlingTeam = bowlingTeam;
	}

	public int getExtras() {
		return extras;
	}

	public void setExtras(int extras) {
		this.extras = extras;
	}
}
