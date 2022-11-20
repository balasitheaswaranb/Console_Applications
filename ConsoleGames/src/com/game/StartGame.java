package com.game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class StartGame {
	public static void main(String[] args) {
		TicTacToc.playerPositions = new ArrayList<Integer>();
		TicTacToc.cpuPositions = new ArrayList<Integer>();
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		boolean flag1 = true;
		while (flag) {
			try {
				System.out.println("\n  1. Start Game \n  2. Exit Game\n");
				System.out.print(" Enter your choice : ");
				int choice = scanner.nextInt();

				switch (choice) {
				case 1:
					flag = false;
					TicTacToc.printGameBoard(TicTacToc.gameBoard);
					break;
				case 2:
					flag = false;
					flag1 = false;
					System.out.println("  Exit..... byee! ");
					break;
				}
			} catch (Exception e) {
				System.out.println("Please enter valid option!!! ");
				scanner.next();
			}
		}

		while (flag1) {
			try {
				System.out.print("\n Enter your position(1-9) : ");
				int playerPosition = scanner.nextInt();
				while (TicTacToc.playerPositions.contains(playerPosition)
						|| TicTacToc.cpuPositions.contains(playerPosition)) {
					System.out.println(" Position taken! Enter a correct position ");
					playerPosition = scanner.nextInt();
				}
				TicTacToc.placePiece(TicTacToc.gameBoard, playerPosition, "player");

				String result = TicTacToc.checkWinner();
				if (result.length() > 0) {
					System.out.println(result);
					break;
				}
				
				int cpuPosition = random.nextInt(9) + 1;
				while (TicTacToc.playerPositions.contains(cpuPosition)
						|| TicTacToc.cpuPositions.contains(cpuPosition)) {
					
					cpuPosition = random.nextInt(9) + 1;
				}
				TicTacToc.placePiece(TicTacToc.gameBoard, cpuPosition, "cpu");

				TicTacToc.printGameBoard(TicTacToc.gameBoard);
				result = TicTacToc.checkWinner();
				if (result.length() > 0) {
					System.out.println(result);
					break;
				}
			} catch (Exception e) {
				System.out.println(" Please enter correct position!!!");
				scanner.next();
			}
		}
		scanner.close();
	}
	

}
