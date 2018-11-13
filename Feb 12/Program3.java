/*
 Betty Guo
 ICS4UI
 02/12/18
 Ms. Harris
 Program 3: Write a program that prompts the user to enter the number of students and each student's name and score, and finally displays the student with the highest score.
 */

import java.util.Scanner;

public class Program3{
    public static void main(String[] args) {
        System.out.println("This program takes input on students' names and scores and outputs the student with the highest score. \n");//outputs user explanation
        Scanner inp = new Scanner(System.in);//create scanner
        
        //prompt user for number of students;
        System.out.println("Enter number of students: ");
        
        int n = Integer.parseInt(inp.nextLine());//takes input for number of student as string, parses into int
        int maxscore = 0;//variable to hold current maximum score
        String maxstudent = "";//variable to hold name of student with current maximum score

        
        for (int i = 0; i < n; i++){//for loop to receive input
            System.out.println("Enter student name: ");//prompt for name
            String student = inp.nextLine();//takes whole line as student name
            System.out.println("Enter student score: ");//prompt for score
            int score = Integer.parseInt(inp.nextLine()); //takes input for score as string, parses into int
            if (score > maxscore){//if entered score is bigger than current largest score, becomes new largest score, replace student name
                maxscore = score;
                maxstudent = student;
            }
        }
        
        System.out.println("The student with the highest mark is: " + maxstudent);//outputs name of student with highest score
        
        
    }
}
