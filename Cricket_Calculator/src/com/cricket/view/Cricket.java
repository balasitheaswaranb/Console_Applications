package com.cricket.view;

import com.cricket.controller.InputController;
import com.cricket.controller.OutputController;
import com.cricket.model.Innings;
import com.cricket.model.Match;

public class Cricket {
	OutputController outputController;

	Cricket() {
		outputController = new OutputController(this);
	}

	public static void main(String[] args) {
		Cricket cricket = new Cricket();
		cricket.process();

	}

	private void process() {
		outputController.storeValues(InputController.getInput());
		showOutput(Match.getInstance().getFirstInnings());
		showOutput(Match.getInstance().getSecondInnings());

	}


	private void showOutput(Innings innings) {
		System.out.println("Team Scores:");
		System.out.println(outputController.getTeamScores(innings));
		System.out.println("Batting:");
		System.out.println(outputController.getBatting(innings));
		System.out.println("Bowling:");
		System.out.println(outputController.getBowling(innings));
		System.out.println("Player Stats:");
		System.out.println(outputController.getPlayerStats(innings));
	}

}
