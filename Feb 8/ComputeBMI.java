import java.util.Scanner;

public class ComputeBMI {
  public static void main(String[] args) {
      //create scanner
    Scanner input = new Scanner(System.in);
    
    // Prompt the user to enter weight in pounds
    System.out.print("Enter weight in pounds: ");
    double weight = input.nextDouble();
    
    // Prompt the user to enter height in inches
    System.out.print("Enter height in inches: ");
    double height = input.nextDouble();
    
    final double KILOGRAMS_PER_POUND = 0.45359237; // Constant
    final double METERS_PER_INCH = 0.0254; // Constant 
    
    // Compute BMI
    double bmi = weight * KILOGRAMS_PER_POUND / 
      ((height * METERS_PER_INCH) * (height * METERS_PER_INCH));

    // Display result
    System.out.println("Your BMI is " + bmi);
      //selection
    if (bmi < 16)
      System.out.println("You are seriously underweight");
      //if bmi >= 16 but < 18 because else if
    else if (bmi < 18)
      System.out.println("You are underweight");
    else if (bmi < 24)
      System.out.println("You are normal weight");
    else if (bmi < 29)
      System.out.println("You are overweight");
    else if (bmi < 35)
      System.out.println("You are seriously overweight");
    else
      System.out.println("You are gravely overweight");
  }
}
