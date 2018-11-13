/*
Unit 1 Assignment 1 Question 4
Betty Guo
Creation Date: 02/21/18
Problem: Write a program that generates 100 random integers between 0 and 9 and displays the count for each number.

CHANGE LOG:
2/23/18
Added user input bulletproofing (Lines 24, 38, 65-79)
Added user prompts (lines 18, 23, 37)
*/

import java.util.*; //import for random generator and array fill capabilities

public class BettyGU1A1Q4program {

    public static void main(String[] args) {//main
        System.out.println("This program will generate 100 integers between 0 and 9 inclusive and output the number of each generated\n"); //user explanation

        //--------------------------------VARIABLES------------------------
        boolean sentinel;

        //------------------ENTER PROGRAM----------------------------------

        System.out.println("Would you like to run this program? Enter y to continue: \n");
        sentinel = userInput(); //takes user input, validates and returns whether y was entered

        while(sentinel){
        //---------------------GENERATE NUMBERS--------------------------
            System.out.println("Generating numbers ... \n"); //user prompt
            int[] counts = randomGenerator(); //execute random number generator and assign returned array of counts to counts

            //---------------OUTPUT COUNTS-------------------------------
            for (int i = 0; i < 10; i++) {
                System.out.println(i + "s generated: " + counts[i]);
            }

            //---------ASK IF CONTINUE-----------------------------------
            System.out.println("Would you like to go again? Enter y to continue: \n");
            sentinel = userInput(); //takes user input, validates and returns whether y was entered

        }

        System.out.println("Bye!"); //goodbye statement
    }
    public static int[] randomGenerator(){ //method that generates random numbers
        int [] randGen = new int[100]; //array to hold generated numbers
        Random rd = new Random();

        for (int i = 0; i < 100; i++){
            randGen[i] = rd.nextInt(10); //generates random integer between 0 and 9 inclusive and assigns to array
        }
        return arrayCount(randGen); //executes arrayCount and returns array with counts

    }
    public static int[] arrayCount(int[] randGen){ //method that counts number of each integer between 0-9 in randomly generated array
        int[] numCounts = new int[10]; //creates array to hold counts of number
        Arrays.fill(numCounts, 0); //initialize entire array with 0

        for (int i = 0; i < 100; i++){
            numCounts[randGen[i]] += 1; //scan numbers and store counts in array
        }

        return numCounts; //returns array with counts
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
