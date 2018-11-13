/*
 Betty Guo
 ICS4UI
 02/12/18
 Ms. Harris
 Program 4: Write a program that displays all the leap years, ten per line, in the twenty-first century (from 2001 to 2100).
 */
import java.util.Scanner;

public class Program4{
    public static void main(String[] args) {
        System.out.println("This program prints out all leap years between 2001 and 2100 \n");//outputs user explanation
        
        Scanner inp = new Scanner(System.in); //creates scanner for input
        boolean contd = false;//boolean sentinel for repeating program at end
        
        do{
            for (int i = 2001; i < 2101; i++){//for loop to cycle through each year from 2001 to 2100
                boolean isLeapYear = (i % 4 == 0 && i % 100 != 0) || (i % 400 == 0); //check if year is leap year
                if (isLeapYear){
                    System.out.println ("Year " + i + "is a leap year.\n");
                }
            }
            System.out.println ("Go again? ('y' or 'n')\n");
            contd = (inp.nextLine()).charAt(0) == 'y';
        }while (contd);
        
        
    }
}

