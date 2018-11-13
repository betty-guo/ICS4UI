/*
Unit 1 Assignment 1 Question 2
Betty Guo
Creation Date: 02/21/18
Problem: Write a program to check an ISBN

CHANGE LOG:
02/22/18:
Added user prompts and explanations (Lines 17, 28, 43, 49, 73)
Added input bulletproofing (Lines 30-47)
02/23/18:
Added whitespace for readability
*/

import java.util.*; //import for scanner

public class BettyGU1A1Q2program {
    public static void main(String[] args) {
        System.out.println("Welcome. This program takes a 9 digit ISBN and outputs the ISBN with its checksum. \n"); //user explanation

        //-----------------------Variables-----------------------
        String ISBN = "";
        Scanner input = new Scanner(System.in);
        boolean sentinel1, sentinel2;

        do {
            sentinel1 = false; //default state

            //-------------------GET INPUT-----------------
            System.out.println("Please enter the 9 digit ISBN in the form XXXXXXXXX, including leading zeros"); //user prompt

            do {
                sentinel2 = true;
                try {
                    ISBN = input.nextLine(); //takes user input and parses into int, throws exception if parsing fails

                    int intCheck = Integer.parseInt(ISBN); //check if integer was entered, if parsing fails throw exception
                    if (ISBN.length() != 9){ //check if number of ISBN entered is 9
                        throw new IllegalArgumentException("Not 9 digits");
                    }else{
                        sentinel2 = false;
                    }

                }catch (java.lang.IllegalArgumentException e){
                    System.out.println ("Invalid input. \nPlease enter the 9 digit ISBN in the format XXXXXXXXX, including leading zeros");
                }
            }while(sentinel2);

            ISBNgenerator(ISBN); //execute ISBN method

            System.out.println("Would you like generate another ISBN? Enter 'y' for yes"); //check if continue
            sentinel1 = userInput(); //takes and validates user input, returns if y was received
        }while (sentinel1);

        System.out.println("Have a good day."); //goodbye message
    }
    public static void ISBNgenerator(String ISBN){
        int sum = 0; //sum for formula
        int checksum; //tenth digit of ISBN

        for (int i = 0; i < 9; i ++){ //loop that cycles through string and adds digit to sum used for formula
            sum += (Math.abs(48-(int)ISBN.charAt(i))) * (i+1);
        }

        checksum = sum%11; //finishes calculations and stores result (10th digit) in array containing other ISBN

        if (checksum == 10){ //add checksum to ISBN
            ISBN += "-X";
        }else {
            ISBN += "-" + Integer.toString(checksum);
        }

        System.out.println("The full ISBN is: " + ISBN); //prints final ISBN
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
