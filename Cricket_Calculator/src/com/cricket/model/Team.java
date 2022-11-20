package com.cricket.model;

import java.util.ArrayList;
import java.util.List;

public class Team {
	private String name;
	private List<Batsman> batsmen = new ArrayList<>();
	private List<Bowler> bowlers = new ArrayList<>();
	private int totalRuns;
	private int totalBalls;
	private int totalWickets;
	private int totalOvers;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Batsman> getBatsmen() {
		return batsmen;
	}

	public void setBatsmen(List<Batsman> batsmen) {
		this.batsmen = batsmen;
	}

	public List<Bowler> getBolwers() {
		return bowlers;
	}

	public void setBolwers(List<Bowler> bolwers) {
		this.bowlers = bolwers;
	}

	public int getTotalRuns() {
		return totalRuns;
	}

	public void setTotalRuns(int totalRuns) {
		this.totalRuns = totalRuns;
	}

	public int getTotalBalls() {
		return totalBalls;
	}

	public void setTotalBalls(int totalBalls) {
		this.totalBalls = totalBalls;
	}

	public int getTotalWickets() {
		return totalWickets;
	}

	public void setTotalWickets(int totalWickets) {
		this.totalWickets = totalWickets;
	}

	public int getTotalOvers() {
		return totalOvers;
	}

	public void setTotalOvers(int totalOvers) {
		this.totalOvers = totalOvers;
	}
	
}
