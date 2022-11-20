package com.cricket.controller;

import java.util.List;
import java.util.Queue;

import com.cricket.model.Batsman;
import com.cricket.model.Bowler;
import com.cricket.model.Innings;
import com.cricket.model.Match;
import com.cricket.view.Cricket;

public class OutputController {

	Cricket cricket;

	public OutputController(Cricket cricket) {
		this.cricket = cricket;
	}

	public void storeValues(Queue<String> input) {
		Match.getInstance().getFirstInnings().getBattingTeam().setName(input.poll());
		Match.getInstance().getFirstInnings().getBowlingTeam().setName(input.poll());
		for (int i = 0; i < 3; i++) {
			Batsman batsman = new Batsman();
			batsman.setName(input.poll());
			Match.getInstance().getFirstInnings().getBattingTeam().getBatsmen().add(batsman);
		}
		for (int i = 0; i < 2; i++) {
			Bowler bowler = new Bowler();
			bowler.setName(input.poll());
			Match.getInstance().getFirstInnings().getBattingTeam().getBolwers().add(bowler);
		}
		for (int i = 0; i < 3; i++) {
			Batsman batsman = new Batsman();
			batsman.setName(input.poll());
			Match.getInstance().getFirstInnings().getBowlingTeam().getBatsmen().add(batsman);
		}
		for (int i = 0; i < 2; i++) {
			Bowler bowler = new Bowler();
			bowler.setName(input.poll());
			Match.getInstance().getFirstInnings().getBowlingTeam().getBolwers().add(bowler);
		}
		Match.getInstance().getSecondInnings().setBattingTeam(Match.getInstance().getFirstInnings().getBowlingTeam());
		Match.getInstance().getSecondInnings().setBowlingTeam(Match.getInstance().getFirstInnings().getBattingTeam());

		int totalRuns = 0, runs = 0, extras = 0, wickets = 0, balls = 0, overs = 0;
		String outcome;
		Batsman striker = Match.getInstance().getFirstInnings().getBattingTeam().getBatsmen().get(0);
		striker.setStatus("In");
		Batsman nonstriker = Match.getInstance().getFirstInnings().getBattingTeam().getBatsmen().get(1);
		nonstriker.setStatus("In");
		Bowler currentBowler = Match.getInstance().getFirstInnings().getBowlingTeam().getBolwers().get(0);
		Bowler nextBowler = Match.getInstance().getFirstInnings().getBowlingTeam().getBolwers().get(1);
		Batsman tempBatsman;
		Bowler tempBowler;

		while (input.size() > 0) {
			outcome = input.poll();
			runs = 0;
			if (outcome.matches("[0-9]+")) {
				runs = Integer.valueOf(outcome);
				striker.setBalls(striker.getBalls() + 1);
				currentBowler.setBallsBowled(currentBowler.getBallsBowled() + 1);
				balls++;
			} else if (outcome.matches("W")) {
				currentBowler.setWickets(currentBowler.getWickets() + 1);
				striker.setBalls(striker.getBalls() + 1);
				striker.setStatus("Out");
				wickets++;
				balls++;
				currentBowler.setBallsBowled(currentBowler.getBallsBowled() + 1);
				striker = Match.getInstance().getFirstInnings().getBattingTeam().getBatsmen().get(2);
				striker.setStatus("In");
			} else if (outcome.matches("[0-9]*Wd$")) {
				runs = Integer.valueOf(outcome.substring(0, outcome.length() - 2));
				striker.setBalls(striker.getBalls() + 1);
				currentBowler.setRuns(currentBowler.getRuns() + 1);
				extras++;
				totalRuns++;
			} else if (outcome.matches("[0-9]*Nb$")) {
				runs = Integer.valueOf(outcome.substring(0, outcome.length() - 2));
				striker.setBalls(striker.getBalls() + 1);
				currentBowler.setRuns(currentBowler.getRuns() + 1);
				extras++;
				totalRuns++;
			} else if (outcome.matches("[0-9]*B$")) {
				runs = Integer.valueOf(outcome.substring(0, outcome.length() - 1));
				striker.setBalls(striker.getBalls() + 1);
				currentBowler.setBallsBowled(currentBowler.getBallsBowled() + 1);
				extras++;
				balls++;
			} else if (outcome.matches("[0-9]*Lb$")) {
				runs = Integer.valueOf(outcome.substring(0, outcome.length() - 2));
				striker.setBalls(striker.getBalls() + 1);
				currentBowler.setBallsBowled(currentBowler.getBallsBowled() + 1);
				extras++;
				balls++;
			}
			striker.setRuns(striker.getRuns() + runs);
			currentBowler.setRuns(currentBowler.getRuns() + runs);
			totalRuns += runs;
			if (runs % 2 == 1) {
				tempBatsman = striker;
				striker = nonstriker;
				nonstriker = tempBatsman;
			}
			if (balls == 6) {
				balls = 0;
				overs++;
				tempBatsman = striker;
				striker = nonstriker;
				nonstriker = tempBatsman;
				tempBowler = currentBowler;
				currentBowler = nextBowler;
				nextBowler = tempBowler;
			}
			if (overs == 5 | wickets == 2) {
				break;
			}
		}

		Match.getInstance().getFirstInnings().getBattingTeam().setTotalRuns(totalRuns);
		Match.getInstance().getFirstInnings().getBattingTeam().setTotalWickets(wickets);
		Match.getInstance().getFirstInnings().getBattingTeam().setTotalOvers(overs);
		Match.getInstance().getFirstInnings().getBattingTeam().setTotalBalls(balls);
		Match.getInstance().getFirstInnings().setExtras(extras);

		int totalRuns1 = 0, runs1 = 0, extras1 = 0, wickets1 = 0, balls1 = 0, overs1 = 0,
				target = Match.getInstance().getFirstInnings().getBattingTeam().getTotalRuns();
		striker = Match.getInstance().getSecondInnings().getBattingTeam().getBatsmen().get(0);
		striker.setStatus("In");
		nonstriker = Match.getInstance().getSecondInnings().getBattingTeam().getBatsmen().get(1);
		nonstriker.setStatus("In");
		currentBowler = Match.getInstance().getSecondInnings().getBowlingTeam().getBolwers().get(0);
		nextBowler = Match.getInstance().getSecondInnings().getBowlingTeam().getBolwers().get(1);

		while (input.size() > 0) {
			outcome = input.poll();
			runs1 = 0;
			if (outcome.matches("[0-9]+")) {
				runs1 = Integer.valueOf(outcome);
				striker.setBalls(striker.getBalls() + 1);
				currentBowler.setBallsBowled(currentBowler.getBallsBowled() + 1);
				balls1++;
			} else if (outcome.matches("W")) {
				currentBowler.setWickets(currentBowler.getWickets() + 1);
				striker.setBalls(striker.getBalls() + 1);
				striker.setStatus("Out");
				wickets1++;
				balls1++;
				currentBowler.setBallsBowled(currentBowler.getBallsBowled() + 1);
				striker = Match.getInstance().getSecondInnings().getBattingTeam().getBatsmen().get(2);
				striker.setStatus("In");
			} else if (outcome.matches("[0-9]*Wd$")) {
				striker.setBalls(striker.getBalls() + 1);
				runs1 = Integer.valueOf(outcome.substring(0, outcome.length() - 2));
				currentBowler.setRuns(currentBowler.getRuns() + 1);
				extras1++;
				totalRuns1++;
			} else if (outcome.matches("[0-9]*Nb$")) {
				runs1 = Integer.valueOf(outcome.substring(0, outcome.length() - 2));
				striker.setBalls(striker.getBalls() + 1);
				currentBowler.setRuns(currentBowler.getRuns() + 1);
				extras1++;
				totalRuns1++;
			} else if (outcome.matches("[0-9]*B$")) {
				runs1 = Integer.valueOf(outcome.substring(0, outcome.length() - 1));
				striker.setBalls(striker.getBalls() + 1);
				currentBowler.setBallsBowled(currentBowler.getBallsBowled() + 1);
				extras1++;
				balls1++;
			} else if (outcome.matches("[0-9]*Lb$")) {
				runs1 = Integer.valueOf(outcome.substring(0, outcome.length() - 2));
				striker.setBalls(striker.getBalls() + 1);
				currentBowler.setBallsBowled(currentBowler.getBallsBowled() + 1);
				extras1++;
				balls1++;
			}
			striker.setRuns(striker.getRuns() + runs1);
			currentBowler.setRuns(currentBowler.getRuns() + runs1);
			totalRuns1 += runs1;
			if (runs1 % 2 == 1) {
				tempBatsman = striker;
				striker = nonstriker;
				nonstriker = tempBatsman;
			}
			if (balls1 == 6) {
				balls1 = 0;
				overs1++;
				tempBatsman = striker;
				striker = nonstriker;
				nonstriker = tempBatsman;
				tempBowler = currentBowler;
				currentBowler = nextBowler;
				nextBowler = tempBowler;
			}
			if (overs1 == 5 | wickets1 == 2 | totalRuns1 > target)
				break;
		}

		Match.getInstance().getSecondInnings().getBattingTeam().setTotalRuns(totalRuns1);
		Match.getInstance().getSecondInnings().getBattingTeam().setTotalWickets(wickets1);
		Match.getInstance().getSecondInnings().getBattingTeam().setTotalOvers(overs1);
		Match.getInstance().getSecondInnings().getBattingTeam().setTotalBalls(balls1);
		Match.getInstance().getSecondInnings().setExtras(extras1);

	}

	public String getTeamScores(Innings innings) {
		String output = "";
		output += innings.getBattingTeam().getName();
		output += " - ";
		output += innings.getBattingTeam().getTotalRuns();
		output += "/" + innings.getBattingTeam().getTotalWickets();
		if (innings.getBattingTeam().getTotalWickets() == 2) {
			output += "(all out, ";
		} else {
			output += "( ";
		}
		output += Match.getInstance().getFirstInnings().getBattingTeam().getTotalOvers();
		if (Match.getInstance().getFirstInnings().getBattingTeam().getTotalBalls() > 0)
			output += "." + Match.getInstance().getFirstInnings().getBowlingTeam().getTotalBalls();
		output += " overs)";

		return output;
	}

	public String getBatting(Innings innings) {
		String output = "";
		List<Batsman> batsmen = innings.getBattingTeam().getBatsmen();
		for (Batsman batsman : batsmen) {
			output += batsman.getName();
			if (!batsman.getStatus().equals("Out"))
				output += "*";
			output += " - " + batsman.getRuns() + " runs ";
			output += "(" + batsman.getBalls() + " balls)\n";
		}
		output += "Innings Extras - " + Match.getInstance().getFirstInnings().getExtras();
		return output;
	}

	public String getBowling(Innings innings) {
		String output = "";
		List<Bowler> bowlers = innings.getBattingTeam().getBolwers();
		for (Bowler bowler : bowlers) {
			output += bowler.getName() + " - ";
			output += bowler.getBallsBowled() / 6;
			if (bowler.getBallsBowled() % 6 != 0)
				output += "." + bowler.getBallsBowled() % 6;
			output += " overs - " + bowler.getRuns() + "/" + bowler.getWickets() + "\n";
		}
		return output;
	}

	public String getPlayerStats(Innings innings) {
		String output = "";
		List<Bowler> bowlers = innings.getBattingTeam().getBolwers();
		List<Batsman> batsmen = innings.getBattingTeam().getBatsmen();
		for (Batsman batsman : batsmen) {
			output += batsman.getName() + " - ";
			output += batsman.getRuns();
			output += "(" + batsman.getBalls() + ") - SR ";
			output += Math.round(((double) batsman.getRuns() / batsman.getBalls() * 100)) + "% - C ";
			output += Math.round(((double) batsman.getRuns() / innings.getBattingTeam().getTotalRuns() * 100)) + "% \n";
		}
		for (Bowler bowler : bowlers) {
			output += bowler.getName() + " - ";
			output += bowler.getRuns() + "/" + bowler.getWickets() + " (";
			output += bowler.getBallsBowled() / 6;
			if (bowler.getBallsBowled() % 6 != 0)
				output += "." + bowler.getBallsBowled() % 6;
			output += ") - W " + bowler.getWickets() + " - C "
					+ Math.round(((double) bowler.getWickets() / innings.getBowlingTeam().getTotalWickets() * 100))
					+ "% "; 

		}
		return output;
	}

}
