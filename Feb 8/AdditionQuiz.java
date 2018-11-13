import java.util.Scanner;

public class AdditionQuiz {
  public static void main(String[] args) {
    //number 1 and 2 are random numbers(?)
    int number1 = (int)(System.currentTimeMillis() % 10);
    int number2 = (int)(System.currentTimeMillis() * 7 % 10);

    // Create a Scanner
    Scanner input = new Scanner(System.in);

    System.out.print(
      "What is " + number1 + " + " + number2 + "? ");
    //gets input
    int answer = input.nextInt();
    
    System.out.println(
      number1 + " + " + number2 + " = " + answer + " is " +
      (number1 + number2 == answer));
    //gives whether answer is true
  }
}
