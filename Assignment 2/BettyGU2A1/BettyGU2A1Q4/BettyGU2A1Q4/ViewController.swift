/*
 Unit 2 Assignment 1 Question 4
 Betty Guo
 Creation Date: 04/10/18
 Problem: WOW ME! This program presents a cat that animates and makes a noise when tapped
 
 REFERENCE:
 https://developer.apple.com/
 */

import UIKit
import AVFoundation

class ViewController: UIViewController {
    //------------DECLARE UI ELEMENTS AND VARIABLES--------
    @IBOutlet weak var catImage: UIImageView! //screen
    @IBOutlet weak var headingLabel: UILabel!
    var animatedCat = cat() //array of cat images
    var catSoundEffect: AVAudioPlayer? //audio player for cat sound
   
    //-------------Entry Point-----------------
    override func viewDidLoad() {
        super.viewDidLoad()
        setupUI()
    }
    
    //-------------Initial UI-----------------------------
    func setupUI(){
        catImage.image = animatedCat[0] //still cat image
    }
    
    //Executes cat animation and sound when screen is tapped
    @IBAction func screenTapped(_ sender: UITapGestureRecognizer) {
        //clear label
        headingLabel.isHidden = true
        
        //animate dice roll
        catImage.animationImages = animatedCat
        catImage.animationDuration = 1
        catImage.animationRepeatCount = 1
        catImage.startAnimating()
        catImage.image = animatedCat[0]
        
        //play cat meow sound
        playCatSound()
        
    }
    
    //accesses file and plays cat sound
    private func playCatSound(){
        if let pathResource = Bundle.main.path(forResource:"Meowing-cat", ofType: "mp3"){ //find file path
            let finishedStepSound = URL(fileURLWithPath: pathResource) //make into url
            catSoundEffect = AVAudioPlayer() //create instance of audio player
            do {
                catSoundEffect = try AVAudioPlayer(contentsOf: finishedStepSound)
                if(catSoundEffect!.prepareToPlay()){
                    print("Preparation success") //troubleshooting marker 1
                    if(catSoundEffect!.play()){
                        print("Sound play success") //troublshooting marker 2
                    }
                }
            }catch{ //catches exception generated if no file
                print ("No file found") //troubleshooting marker 3
            }
        }
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
}
