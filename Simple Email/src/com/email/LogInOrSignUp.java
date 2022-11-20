package com.email;

import java.util.Collection;
import java.util.Scanner;

public class LogInOrSignUp {
	Scanner scanner = new Scanner(System.in);

        public void signUp(Collection<Email> worker){
            boolean answer = false;
            System.out.println("Welcome to Email for workers!\nPlease enter your email and password");
            while(!answer){
                System.out.println("Email:");
                
                String userEmail = scanner.next();
                System.out.println("Password:");
              
                String userPassword = scanner.next();
                System.out.println("Just a second: we are checking you in our system ");

                for(Email w: worker){

                    if (userEmail == w.getEmail().toString()){
                        System.out.println(w.getEmail());
                        answer = true;
                    }
                }
                if(answer == false){
                    System.out.println("Incorrect email. Please enter again");
                    System.out.println("Your: " + userEmail);
                    ;
                }
            }


        }

    public int scannerForAnswer(int quantityOfVarients) {
        boolean flag = true;
        int answer = 0;
        while (flag) {

            try {
                
                answer = scanner.nextInt();
            } catch (Exception e){
                System.out.println("Please enter the number");
            }
            for (int i = 1; i <= quantityOfVarients; i++) {
                if (answer == i) {
                    flag = false;
                }
            }
            if (flag == true){
                System.out.println("You chose a wrong option. Please choose again");
            }

        }
        return answer;
    }
}


