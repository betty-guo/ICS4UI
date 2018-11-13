/*
 Betty Guo
 ICS4UI
 02/13/18
 Ms. Harris
 Program 1: Write an expression that returns a random integer between 24 and 45.  Write an expression that returns a random integer between 0 and 999. Write an expression that returns a random integer between 2.2 and 22.2.
 */
public class Program1{
    public static void main(String[] args){//main
        System.out.println ("This program prints out three random integers between 24 and 45, 0 and 999, 2.2 and 22.2, respectively\n");//user prompt
        System.out.println(RandInt1() + "\n" + RandInt2()+ "\n" + RandInt3() + "\n" );//prints random integers

    }
    public static int RandInt1(){//method to return randint between 24 and 45
        return (int)(24 +(int)(Math.random()*22));
    }
    public static int RandInt2(){//method to return randint between 0 and 999
        return (int)(Math.random()*1000);
    }
    public static int RandInt3(){//method to return randint between 2.2 and 22.2
        return (int)(2.2 +(int)(Math.random()*21));
    }
}
