#!/usr/bin/swift
/*
 Betty Guo
 April 12 2018
 Swift Test Part B
 */

//--------DECLARE VARIABLES------
var output: [Int] = []
var readInput: String

//--------USER PROMPT------------
print("Welcome! In this program you will enter 10 integers, one on each line. The program will then output each distinct number in the collection you have entered")

//---------TAKE INPUT-----------
while (true){ //loop forever until user ends
    print ("Please enter your numbers:")
    
    for _ in 1...10{
        readInput = readLine()!
        var alreadyThere: Bool = false //var to keep track of numbers
        for value in output{
            if (Int(readInput)! == value){
                alreadyThere = true
            }
        }
        if !alreadyThere{
            output.insert(Int(readInput)!, at: output.count)
        }
    }
    
    //--------PRINT OUTPUT---------
    
    print ("Your distinct numbers inputted are:")
    for value in output{
        print(value)
    }
    
    //------ASK IF CONTINUE-----
    
    print("Would you like to retry? Enter 'n' for no, else enter any string")
    readInput = readLine()!
    if readInput == "n"{
        break
    }
}

//-------------USER PROMPT-------------
print ("Bye!")
