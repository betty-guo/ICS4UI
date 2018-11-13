/*
 Unit 2 Assignment 1 Question 1
 Betty Guo
 Creation Date: 04/09/18
 Problem: Write a program that checks the ratings of 5 of your favorite movies and places them in the dictionary.  Give the user some instructions, then allow them to check for possible entries in your dictionary.

 REFERENCE:
 https://developer.apple.com/
 */

import UIKit

class ViewController: UIViewController {

    //----------DECLARE UI ELEMENT REFERENCES-----------
    @IBOutlet weak var headingLabel: UILabel!
    @IBOutlet weak var instructionsLabel: UILabel!
    @IBOutlet var movieButtons: [UIButton]!
    @IBOutlet weak var movieImage: UIImageView!
    @IBOutlet weak var ratingsLabel: UILabel!


    //-------DICTIONARY WITH MOVIES_____________________
    var favMovies = ["The Godfather": Movie(rating: 9.2, image: "godfather.jpg"),
                     "The Shawshank Redemption": Movie(rating: 9.3, image: "shawshank.jpg"),
                     "Pulp Fiction": Movie(rating: 8.9, image: "pulp.jpg"),
                     "The Empire Strikes Back": Movie(rating: 8.8, image: "star.jpg"),
                     "Forrest Gump": Movie(rating: 8.8, image: "forrest.jpeg")]

    //-------------Entry Point-----------------
    override func viewDidLoad() {
        super.viewDidLoad()
        setupUI()
    }

    //-------------Initial UI-----------------------------
    func setupUI(){
        //set labels text
        headingLabel.text = "Welcome!"
        
        instructionsLabel.text = "Below is a list of my top 5 favourite movies! Click on each button to see the rating (out of 10)."
        instructionsLabel.lineBreakMode = .byWordWrapping
        instructionsLabel.numberOfLines = 0;
        
        ratingsLabel.text = ""
        
        //sets button text
        movieButtons[0].setTitle("The Godfather", for: .normal)
        movieButtons[1].setTitle("The Shawshank Redemption", for: .normal)
        movieButtons[2].setTitle("Pulp Fiction", for: .normal)
        movieButtons[3].setTitle("The Empire Strikes Back", for: .normal)
        movieButtons[4].setTitle("Forrest Gump", for: .normal)
        
    }

    //when button is tapped: displays rating and image
    @IBAction func buttonTapped(_ sender: UIButton) {
        if let movie = favMovies[sender.title(for: .normal)!]{
            ratingsLabel.text = ("Rating: \(movie.rating)")
            movieImage.image = movie.image
        }
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

}
    
  