/*
Unit 1 Assignment 1 Question 5
Betty Guo
Creation Date: 02/23/18
Problem: Wow Me! This program plays a slideshow of cute animals
CHANGE LOG:
02/25/18
Fixed continue window
*/

//---------GUI IMPORT--------------
import java.awt.event.*;
import javax.swing.*;

public class BettyGU1A1Q5program extends JFrame
implements ActionListener{
    //----------------------GLOBAL VARIABLES-------------------------
    JButton button;
    String[] cats = new String[10]; //create array to hold cat images
    int count = 0;
    //----------------------CONSTRUCTOR, CREATES GUI------------------
    BettyGU1A1Q5program(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1440, 900);
        setLocationRelativeTo(null); // Center the frame

        button = new JButton(new ImageIcon("intro1.jpg"));
        button.setPreferredSize(new java.awt.Dimension(1440,900));
        add(button);

        setVisible(true);
        introScreen(); //execute intro sequence

        button.addActionListener(this);

    }
    //---------------------MAIN---------------------------------
    public static void main(String[] args) {
        BettyGU1A1Q5program frame = new BettyGU1A1Q5program();
        frame.initializeArray(); //initialize cat array with files
    }
    //---------------------INITIALIZE ARRAY WITH FILE NAMES----------------
    public void initializeArray(){
        /*CREDITS: ALL CAT PHOTOS ARE FROM https://wallpapercave.com/free-cute-kitten-wallpapers
        ALL OTHERS: http://getwallpapers.com/collection/baby-ducks-wallpaper OR from personal photo library
         */
        cats[0] = "cat1.jpg";
        cats[1] = "cat2.jpg";
        cats[2] = "cat3.jpg";
        cats[3] = "cat4.jpg";
        cats[4] = "cat5.jpg";
        cats[5] = "cat6.jpg";
        cats[6] = "cat7.jpg";
        cats[7] = "cat8.jpg";
        cats[8] = "cat9.jpg";
        cats[9] = "cat10.jpg";
    }
    //------------- PAUSES PROGRAM---------------------
    public static void delay(int time){
        try {
            //sleep 5 seconds
            Thread.sleep(time * 1000);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //-----------------------INTRO SEQUENCE------------------
    public void introScreen(){
        delay(5); //delay 5 seconds
        changeImage("intro2.jpg");
        delay(5); //delay 5 seconds
        changeImage("intro3.jpg");

    }
    //----------------------REFRESH IMAGE ON SCREEN---------------
    public void changeImage(String image){
        button.setIcon(new ImageIcon(image));
        button.revalidate();
    }
    //-----------------------BUTTON CLICK EVENT----------------
    public void actionPerformed(ActionEvent e) {
        if(count == 10){ //if no more pictures exit program
            System.exit(0);
        }
            changeImage(cats[count]); //change photo to next item in array
            count ++;

    }
}

