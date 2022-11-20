package com.rock.paper;
import java.util.Random;
import java.util.Scanner;

public class SimpleGames {
	
		
		    public static void main(String[] args) {
		        // vars for input and random functions
		        Scanner input = new Scanner(System.in);
		        Random rand = new Random();
		        
		        // variables
		        int number = rand.nextInt(10), guess, countGuess = 0, maxGuess = 3;
		        boolean outOfGuess = false;

		        while (!outOfGuess) {
		            if (countGuess < maxGuess) {
		                System.out.println((maxGuess - countGuess) + " guesses left");
		                System.out.print("Guess: ");
		                guess = input.nextInt();

		                if (guess == number) {
		                    System.out.println("You win");
		                    break;
		                }
		                countGuess++;
		            } else {
		                System.out.println("You lost\nOur number was " + number);
		                outOfGuess = true;
		            }
		        }input.close();
		    }
		}
		
