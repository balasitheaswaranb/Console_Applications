package com.rock.paper;
	import java.util.Random;
	import java.util.Scanner;

	public class RockPaperScissors {
	  public static void main(String[] args) {  
	    Scanner scanner = new Scanner(System.in);
	    
	    while (true) {
	      String[] rockPaperScissors = {"rock", "paper", "scissor"};
	      String computerMove = rockPaperScissors[new Random().nextInt(rockPaperScissors.length)];
	      String playerMove;
	      
	      while(true) {
	        System.out.println("Please enter your move [Rock press r (or) Paper press p (or) Scissor press s]");
	        playerMove = scanner.nextLine();
	        if (playerMove.equals("r") || playerMove.equals("p") || playerMove.equals("s")) {
	          break;
	        }
	        System.out.println(playerMove + " is not a valid move.");
	      }
	      
	      System.out.println("Computer played: " + computerMove);
	      
	      if (playerMove.equals(computerMove)) {
	        System.out.println("The game was a tie!");
	      }
	      else if (playerMove.equals("r")) {
	        if (computerMove.equals("p")) {
	          System.out.println("You lose!");
	          
	        } else if (computerMove.equals("s")) {
	          System.out.println("You win!");
	        }
	      }
	      
	      else if (playerMove.equals("p")) {
	        if (computerMove.equals("r")) {
	          System.out.println("You win!");
	          
	        } else if (computerMove.equals("s")) {
	          System.out.println("You lose!");
	        }
	      }
	      
	      else if (playerMove.equals("s")) {
	        if (computerMove.equals("p")) {
	          System.out.println("You win!");
	          
	        } else if (computerMove.equals("r")) {
	          System.out.println("You lose!");
	        }
	      }
	      
	      System.out.println("Play again? (y/n)");
	      String playAgain = scanner.nextLine();
	      
	      if (!playAgain.equals("y")) {
	        break;
	      }
	    }
	    scanner.close();
	  }
	}
	
