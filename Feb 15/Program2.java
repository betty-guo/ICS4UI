import java.util.*;

public class Program2 {
    public static void main (String[] args) {
        
        boolean sentinel = false;//creates sentinel for loop
        ArrayList<String> myList= new ArrayList<String>();//creates object myList of type ArrayList<String>
        Scanner input = new Scanner(System.in);//creates input scanner
        
        for (int i = 0; i < 5; i++){//initialize myList
            myList.add(i, Integer.toString(i));
        }
        
        do{//do loop that runs user input/output until the user does not wish to continue
            sentinel = false;//set continue to false
            System.out.println ("The current array is: " + myList + "\n");
            System.out.println ("Would you like to insert (INS) or remove (REM) a value from the array?\n");
            
            String userResponse = input.nextLine() ;// takes user input and stores in variable

            if ((userResponse.charAt(0) == 'I') &&(userResponse.charAt(1) == 'N') &&(userResponse.charAt(2) == 'S')){//if user wants to insert
                System.out.println ("What would you like to add to the array?\n");//user prompt
                String userResponse2 = input.nextLine();//take input
                System.out.println ("Where in the array? (0-" + (myList.size()) + ")\n");//user prompt
                int place = Integer.parseInt(input.nextLine());
                myList.add(place, userResponse2);//add to arraylist
                System.out.println ("The new array is: " + myList);//output new array
            } else{
                if((userResponse.charAt(0) == 'R') &&(userResponse.charAt(1) == 'E') &&(userResponse.charAt(2) == 'M')){//if user wants to remove
                    System.out.println ("What index of the array would you like to be removed? (0-" + (myList.size()-1) + ")\n");//user prompt
                    int userResponse3 = Integer.parseInt(input.nextLine());//take input
                    myList.remove(userResponse3);//remove from arrayList
                    System.out.println ("The new array is: " + myList);//output new array
                }
            }
            
            System.out.println("Would you like to continue? Enter y to continue. \n");//user prompt to continue
            if(input.nextLine().charAt(0) == 'y'){//if entered y
                sentinel = true;//set continue to true
            }
                
            
        }while(sentinel);//continue while user says so
        
        System.out.println("Thanks for participating!\n");//goodbye message
        }
    }
