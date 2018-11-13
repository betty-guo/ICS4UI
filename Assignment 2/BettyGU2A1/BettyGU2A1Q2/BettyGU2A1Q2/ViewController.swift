/*
 Unit 2 Assignment 1 Question 2
 Betty Guo
 Creation Date: 04/09/18
 Problem: Write a program to play a variation of the game of craps
 
 REFERENCE:
 https://developer.apple.com/
 */

import UIKit
import Foundation

class ViewController: UIViewController {
    
    //----------DECLARE UI ELEMENT REFERENCES-----------
    @IBOutlet weak var headingLabel: UILabel!
    @IBOutlet weak var instructionsLabel: UILabel!
    @IBOutlet weak var rollButton: UIButton!
    @IBOutlet weak var rollAnimationImage: UIImageView!
    @IBOutlet weak var scrollScreen: UITextView!
    
    //--------------VARIABLES---------------------
    var animatedDice = dice() //array with dice animation images
    var currentText = "" //string with current text
    
    //-------------Entry Point-----------------
    override func viewDidLoad() {
        super.viewDidLoad()
        setupUI()
    }
    
    //-------------Initial UI-----------------------------
    func setupUI(){
        //set up labels
        headingLabel.text = "Game of Craps"
        
        instructionsLabel.text = """
        Welcome to Craps.
        RULES:
        In craps, two 6 faced die are rolled.
        If the sum rolled is 2, 3, or 12 (craps) you lose.
        If the sum rolled is 7 or 11 (natural) you win.
        If any other sum is rolled (called a point) we continue rolling until the same point value (win!) or a 7 (lose) is rolled.
        Click roll to play.
        """
        
        instructionsLabel.lineBreakMode = .byWordWrapping
        instructionsLabel.numberOfLines = 0;
        
        //set up buttons
        rollButton.setTitle("Roll", for: .normal)
        
        //set up image
        rollAnimationImage.image = animatedDice[0]
        
        //set up scrolling text
        scrollScreen.text = currentText
        
    }
    
    //------------------------roll button tapped --------------
    @IBAction func buttonTapped(_ sender: UIButton) { //when button is tapped: rolls dice and prints to screen
        
        //reset from previous round
        currentText = ""
        printToScreen("")
        
        //animate dice roll
        rollAnimationImage.animationImages = animatedDice
        rollAnimationImage.animationDuration = 0.2
        rollAnimationImage.animationRepeatCount = 1
        rollAnimationImage.startAnimating()
        rollAnimationImage.image = animatedDice[0]
        
        playCraps() //executes game
        
        printToScreen("Click roll to play again\n") //user prompt
        
    }
    

    
    //--------------------print user prompts--------
    
    func printToScreen(_ toPrint: String){
        //call display text function
        currentText += toPrint
        scrollScreen.text = currentText
        
        //if text exceeds scroll view, go to bottom of text
        if(scrollScreen.text.count > 0 ) {
            let bottom = NSMakeRange(scrollScreen.text.count - 1, 1)
            scrollScreen.scrollRangeToVisible(bottom);
        }
    }
    //--------------------play craps game----------------
    func playCraps() {
        var roundEnd = false;
        let roll = diceRoll(); //temp roll result
        
        //-------------------------RESULTS OF GAME----------------------
        
        switch(true){
            case (roll == 2 || roll == 3 || roll == 12): //if 'craps' is rolled
                printToScreen("YOU LOSE!\n")
            case (roll == 7 || roll == 11): //if 'natural' is rolled
                printToScreen("YOU WIN!\n")
            default: //if 'points' is rolled
                let lastRoll = roll;
                printToScreen("Your points are: \(lastRoll)\n")
                
                while (!roundEnd) { //roll until result is achieved
                    let newRoll = diceRoll();
                    if newRoll == lastRoll { //same point sum rolled
                        roundEnd = true;
                        printToScreen("YOU WIN!\n") //print results
                    }
                    if newRoll == 7 { //rolls 7
                        roundEnd = true; //game over, player loses, exit loop
                        printToScreen("YOU LOSE!\n") //print results
                    }
                }
            }
    }
    
    //------------------------pseudo roll dice----------------
    func diceRoll() -> Int{ //pseudo rolls dice and returns sum of roll
        let dice1 = Int(arc4random_uniform(6)+1) //assigns random integer between 1 and 6 inclusive to dice 1
        let dice2 = Int(arc4random_uniform(6)+1) //assigns random integer between 1 and 6 inclusive to dice 2
    
        printToScreen("You rolled \(dice1) + \(dice2) = \(dice1+dice2) \n") //print result
    
        return dice1 + dice2; //returns sum of dice rolls
    
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
}



