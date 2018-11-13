/*
Unit 1 Assignment 1 Question 1
Betty Guo
Creation Date: 02/21/18
Problem: Write a program that plays rock scissors paper.

CHANGE LOG:
02/22/18: Added bulletproofing for user input (Lines 48-62, 77-86, 102-114)
Added hash map for moves(Lines 30-40)
02/23/18: Added better user prompts for rules and clarity (Lines 19-22)
Added user input to enter into game (Lines 25-26)
*/

import java.util.*; //import for Scanner and HashMap

public class BettyGU1A1Q1program {
    public static void main(String[] args) {
        //------------------- GREETING ----------------------------------------------------
        System.out.println("Welcome! Let's play rock paper scissors!\n");
        System.out.println("RULES: Both you and the computer will choose either rock, paper or scissors.");
        System.out.println("Rock beats paper, paper beats scissors, scissors beats rock.");
        System.out.println("If the same object is thrown it is a tie.\n");

        //------------------------ VARIABLES -------------------------------------------
        Scanner input = new Scanner(System.in);
        boolean sentinel, sentinel2; //sentinels for loops
        int computerMove;
        int round = 0;

        HashMap <String, Integer> NametoNumber = new HashMap<>(); //creates hashmaps to link name of object to number
        HashMap <Integer, String> NumbertoName = new HashMap<>();

        //initialize hashmaps
        NametoNumber.put("ROCK", 0);
        NametoNumber.put("PAPER", 1);
        NametoNumber.put("SCISSORS", 2);

        NumbertoName.put(0, "ROCK");
        NumbertoName.put(1, "PAPER");
        NumbertoName.put(2, "SCISSORS");

        //--------------- USER INPUT FOR ENTERING GAME ---------------------------------

        System.out.println("Would you like to play? Enter y if yes, n if no: ");
        sentinel = userInput(); //validates input and returns result of user input


        //---------------------------------PLAY GAME ---------------------------------

        while (sentinel){

            round++; //increase round count
            sentinel = false; //reset continue sentinel to false

            computerMove = (int)(Math.random() * 2); //generate random number and store in computerMove

            //----------------USER MOVE INPUT-------------------------------------------
            System.out.println("Round " + round + " . Please enter your move (ROCK, PAPER, SCISSORS): "); //user prompt
            String userMove ; //default rock

            do{ //bulletproof against invalid input
                sentinel2 = false;
                userMove = (input.nextLine()).trim(); //get input and store in variable userMove

                if (!(userMove.equals("ROCK") || userMove.equals("PAPER") || userMove.equals("SCISSORS"))){
                    System.out.println("Bad input. Please reenter");
                    sentinel2 = true; //rerun loop
                }
            }while(sentinel2);

            if(NametoNumber.get(userMove) == computerMove){ //check if same as computer move
                System.out.println("You both threw " + NumbertoName.get(computerMove) + ". Tie!");
            } else{ //if not a tie
                /*
                if difference between userMove and computerMove is 1, user wins
                    userMove: SCISSORS(2), computer: PAPER(1),  2-1 = 1
                    userMove: PAPER(1), computer: ROCK(0),  1-0 = 1
                if difference between userMove and computerMove is 2, user wins
                    userMove: ROCK(0), computerMove: SCISSORS(2), 2-0 = 2
                else computer wins
                */
                if ((NametoNumber.get(userMove) - computerMove == 1)||(computerMove - NametoNumber.get(userMove) == 2))
                {
                    System.out.println("The computer threw a " + NumbertoName.get(computerMove) + ". You threw a " + userMove + ". You win!\n");
                }else {
                    System.out.println("The computer threw a " + NumbertoName.get(computerMove) + ". You threw a " + userMove + ". You lose\n");
                }
            }

            //----------------- CHECK FOR NEXT ROUND --------------------------------------
            System.out.println("Would you like to play again? Enter y to play again, n to stop");
            sentinel = userInput();
        }

        System.out.println("Thanks for playing! Have a great day!\n");

    }
    public static boolean userInput(){
        String tempInput = "y"; //string to hold input for bulletproofing, default length is one character
        Scanner input = new Scanner(System.in);
        boolean sentinel;

        do { //bulletproofing input

            sentinel = false; //reset loop

            if (tempInput.length() != 1){ //if looping for second time, output error message
                System.out.println("Unaccepted input. Please reenter.");
            }

            tempInput = input.nextLine(); //take input

            if (tempInput.length() == 1) { //if input is single character
                sentinel = (tempInput.charAt(0) == 'y'); //and input is y then sentinel is true
            }

        }while(tempInput.length() != 1); //loops again if input is not single character

        return sentinel;
    }


}