package com.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacToc {
	static ArrayList<Integer> playerPositions;
	static ArrayList<Integer> cpuPositions;
	static char[][] gameBoard = { { ' ', '|', ' ', '|', ' ' }, 
                                  { '-', '+', '-', '+', '-' },
                                  { ' ', '|', ' ', '|', ' ' },
                                  { '-', '+', '-', '+', '-' },
                                  { ' ', '|', ' ', '|', ' ' } };
	
	public static void printGameBoard(char[][] gameBoard) {
		for (char[] row : gameBoard) {
			for (char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}

	public static void placePiece(char[][] gameBoard, int position, String user) {
		char symbol = ' ';
		if (user.equals("player")) {
			symbol = 'X';
			playerPositions.add(position);
		} else if (user.equals("cpu")) {
			symbol = 'O';
			cpuPositions.add(position);
		}
		switch (position) {
		case 1:
			gameBoard[0][0] = symbol;
			break;
		case 2:
			gameBoard[0][2] = symbol;
			break;
		case 3:
			gameBoard[0][4] = symbol;
			break;
		case 4:
			gameBoard[2][0] = symbol;
			break;
		case 5:
			gameBoard[2][2] = symbol;
			break;
		case 6:
			gameBoard[2][4] = symbol;
			break;
		case 7:
			gameBoard[4][0] = symbol;
			break;
		case 8:
			gameBoard[4][2] = symbol;
			break;
		case 9:
			gameBoard[4][4] = symbol;
			break;
		default:
			break;
		}
	}

	public static String checkWinner() {
		List<Integer> topRow = Arrays.asList(1, 2, 3);
		List<Integer> middleRow = Arrays.asList(4, 5, 6);
		List<Integer> bottomRow = Arrays.asList(7, 8, 9);
		List<Integer> leftColumn = Arrays.asList(1, 4, 7);
		List<Integer> middleColumn = Arrays.asList(2, 5, 8);
		List<Integer> rightColumn = Arrays.asList(3, 6, 9);
		List<Integer> cross1 = Arrays.asList(1, 5, 9);
		List<Integer> cross2 = Arrays.asList(7, 5, 3);

		List<List<Integer>> winningConditions = new ArrayList<List<Integer>>();
		winningConditions.add(topRow);
		winningConditions.add(middleRow);
		winningConditions.add(bottomRow);
		winningConditions.add(leftColumn);
		winningConditions.add(middleColumn);
		winningConditions.add(rightColumn);
		winningConditions.add(cross1);
		winningConditions.add(cross2);

		for (List<Integer> l : winningConditions) {
			if (playerPositions.containsAll(l)) {
				return " Congratulations you won!!!";
			} else if (cpuPositions.containsAll(l)) {
				return " CPU wins! Sorry :(";
			} else if (playerPositions.size() + cpuPositions.size() == 9) {
				return " Game Draw";

			}
		}
		return "";
	}
}
