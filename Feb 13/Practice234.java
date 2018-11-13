
/*
 Betty Guo
 ICS4UI
 02/13/18
 Ms. Harris
 Program 2: convert between Celsius and Fahrenheit
 Program 3: method that prints characters
 Program 4: random character prints
 */
import java.util.Scanner;

public class Practice234{
    static Scanner inp= new Scanner(System.in);//create scanner for input
    public static void main (String[] args){//main
        
        //program 2
        System.out.println("This program converts between Celsius and Fahrenheit\n");//user prompt for program 2
        System.out.println("The temperature in Fahrenheit is " + CelsiusToFahrenheit() + "\n");//executes method for program 2
        
        //program 3
        System.out.println("This program prints out some characters\n");//user prompt for program 3
        
        System.out.println("What is the first character would you like to print? ");
        char temp1 = (inp.nextLine()).charAt(0);//gets input and store in temp variable
        System.out.println("What is the second character would you like to print? ");
        char temp2 = (inp.nextLine()).charAt(0);//gets input and store in temp variable
        System.out.println("How many characters per line? ");
        int temp3 = Integer.parseInt(inp.nextLine());//gets input and stores in temp variable
        printChars(temp1, temp2, temp3);//executes method for program 3
        
        printRandChar();//executes method for program 4
        
    }
    public static double CelsiusToFahrenheit(){//method for program 2
        System.out.println("Please give a temperature in Celsius: ");//prompts for temperature
        double Celsius = Double.parseDouble(inp.nextLine());//gets user input and stores in variable
        double Fahrenheit = (1.8 * Celsius) + 32.0; //gets result of conversion and stores in Fahrenheit variable
        
        return Fahrenheit;
        
    }
    public static void printChars(char cr1, char chr, int numberPerLine){//method for program 3
        for (int q = 0; q < numberPerLine; q++){//prints one line of cr1 with number of characters needed
            System.out.print(cr1);
        }
        System.out.println ("\n");//new line
        for (int q = 0; q < numberPerLine; q++){//prints one line of chr with number of characters needed
            System.out.print(chr);
        }
        System.out.println ("\n");//new line
    }
    public static void printRandChar(){//method for program 4
        System.out.println("This program outputs 100 uppercase letters and 100 single digits, 10 per line\n");//user prompt
        RandomCharacter CalltoClass = new RandomCharacter();//variable created to execute methods from random character class
        
        for (int i = 0; i < 10; i++){//prints 100 uppercase letters, 10 per line
            for (int q = 0; q < 10; q++){
                System.out.print(CalltoClass.getRandomUpperCaseLetter());
            }
            System.out.print("\n");
        }
        
        for (int i = 0; i < 10; i++){//prints 100 single digits, 10 per line
            for (int q = 0; q < 10; q++){
                System.out.print(CalltoClass.getRandomDigitCharacter());
            }
            System.out.print("\n");
        }
    
    }
}
