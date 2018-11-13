/*
Unit 1 Assignment 1 Question 3
Betty Guo
Creation Date: 02/21/18
Problem: Write a program that plays a game of craps

CHANGE LOG:
02/22/18
Added user input bulletproofing (Lines 31, 38, 102-124)
02/23/18
Added user prompts and explanations (Lines 19-25, 31, 38, 43)
*/

import java.util.*; //import for Random and Scanner classes

public class BettyGU1A1Q3program {
    public static void main(String[] args) {
        //---------output rules and greeting------------------------------------
        System.out.println("Welcome! This program plays a modified game of craps\n");
        System.out.println("RULES:");
        System.out.println("In craps, two 6 faced die are rolled");
        System.out.println("If the sum rolled is 2, 3, or 12 (craps) you lose");
        System.out.println("If the sum rolled is 7 or 11 (natural) you win ");
        System.out.println("If any other sum is rolled (called a point), ");
        System.out.println("we continue rolling until the same point value (win!) or a 7 (lose) is rolled.\n");

        //-----------------------VARIABLES-----------------------------------------
        boolean sentinel;

        //-----------------------USER INPUT-----------------------------------------
        System.out.println("Would you like to play? Enter y if yes, n if no: ");
        sentinel = userInput(); //takes and validate user input

        //---------------------------PLAY GAME--------------------------------------
        while(sentinel){
            playCraps(); //execute playCraps method

            System.out.println("Would you like to play again? Enter 'y' for yes, 'n' for no");//check if continue
            sentinel = userInput();

        }

        System.out.println("Thanks for playing!");//goodbye message

    }
    public static boolean playCraps(){
        boolean win = false; //winner marker
        boolean gameEnd = false;
        int roll = diceRoll(); //temp roll result

        //-------------------------RESULTS OF GAME------------------------------------
            if (roll == 2 || roll == 3 || roll == 12) { //if 'craps' is rolled
                System.out.println("You lose!\n");
            }
            if (roll == 7 || roll == 11) { //if 'natural' is rolled
                win = true;
                System.out.println("You win!\n");
            } else { //if 'points' is rolled
                int lastRoll = roll;
                System.out.println("Your points are: " + lastRoll);

                while (!gameEnd) { //roll until result is achieved
                    int newRoll = diceRoll();
                    if (newRoll == lastRoll) { //same point sum rolled
                        gameEnd = true;
                        win = true; //game over, player wins, exit loop
                        System.out.println("You win!\n"); //print results
                    }
                    if (newRoll == 7) { //rolls 7
                        gameEnd = true; //game over, player loses, exit loop
                        System.out.println("You lose!\n"); //print results
                    }
                }
            }

        return win;
    }
    public static int diceRoll(){ //pseudo rolls dice and returns sum of roll
        Random rd = new Random();
        int dice1, dice2;

        dice1 = rd.nextInt(6) + 1; //assigns random integer between 1 and 6 inclusive to dice 1
        dice2 = rd.nextInt(6) + 1; //assigns random integer between 1 and 6 inclusive to dice 2

        System.out.println("You rolled " + dice1 + " + " + dice2 + " = " + (dice1+dice2)); //print result

        return dice1 + dice2; //returns sum of dice rolls

    }
    public static boolean userInput(){ //validates and return y or n user input
        String tempInput = "y"; //string to hold input for bulletproofing, default length is one character
        Scanner input = new Scanner(System.in);

        do { //bulletproofing input

            if (tempInput.length() != 1){ //if looping for second time, output error message
                System.out.println("Unaccepted input. Please reenter.");
            }

            tempInput = input.nextLine(); //take input

        }while(tempInput.length() != 1); //loops again if input is not single character

        return tempInput.charAt(0) == 'y';
    }
}
