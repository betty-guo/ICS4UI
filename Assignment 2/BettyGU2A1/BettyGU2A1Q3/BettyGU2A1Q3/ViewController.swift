/*
 Unit 2 Assignment 1 Question 3
 Betty Guo
 Creation Date: 04/11/18
 Problem: Write a program that creates an editable bucket list
 
 REFERENCE:
 https://developer.apple.com/
 ICS4UI Classroom: Ms Harris' Bucket List
 */

import UIKit

class ViewController: UIViewController {
//--------------------DECLARE VARIABLES-------------------
    @IBOutlet weak var textScreen: UITextView! //to print to screen
    var currentText = "" //variable to hold screen output
    
    var bucketList = [ //my bucket list
        "Go to Quebec",
        "Eventually get the house uncluttered, cleaned up",
        "Attend a Wedding",
        "Bungee Jumping",
        "Be so happy I pass out"]

    var teacherBucketList = [ //teacher's bucket list
        "Visit and/or stay in every Canadian National Park (yes, Polar Bear too)",
       "Visit the Baltics (possibly on a cruise)",
        "Introduce a new friend/colleague to wilderness camping",
        "Build a retirement home/cottage off the grid",
        "Eventually get the house uncluttered, cleaned up"]
    
    //---------------------entry point---------------
    override func viewDidLoad() {
        super.viewDidLoad()
        
        //user prompt
        printToScreen( """
            Welcome to the Bucket List!
            A bucket list is, by definition, a list of things that you want to do before you die.  The term gained in popularity after the 2007 movie “The Bucket List” where Morgan Freeman and Jack Nicholson (both of whose characters are dying of cancer) create a bucket list of things to do before they die – and then actually do them.
            """)
        printToScreen("Click buttons below to add, remove or compare your list with the teacher's")
        printList()
        
    }
    
    //-------------------print Bucket List-------------
    func printList(){
        printToScreen("Your bucket list is:")
        for (index, item) in bucketList.enumerated() {
            printToScreen("   \(index + 1). \(item)")
        }
    }
    
    //------------------print to screen-------
    func printToScreen(_ printElement: String){
        
        //add text to screen and scroll to bottom
        currentText += "\n\n"
        currentText += printElement
        textScreen.text = currentText
        
        if(textScreen.text.count > 0 ) {
            let bottom = NSMakeRange(textScreen.text.count - 1, 1)
            textScreen.scrollRangeToVisible(bottom);
        }
    }
    
    //------------------add to bucket list---------------------
    @IBAction func addBucket(_ sender: UIButton) {
        
        //Creating UIAlertController and
        //Setting title and message for the alert dialog
        let alertController = UIAlertController(title: "Add to Bucket List", message: "Enter your new bucket list item and its place on the list (1-\(bucketList.count + 1))", preferredStyle: .alert)
        
        //the confirm action taking the inputs
        let confirmAction = UIAlertAction(title: "Enter", style: .default) { (_) in

            var bucketItem: String?
            var placeOnList: String?
            
            //getting the input values from user
            bucketItem = alertController.textFields?[0].text
            placeOnList = alertController.textFields?[1].text
            
            if(Int(placeOnList!) != nil && Int(placeOnList!)! > 0 && Int(placeOnList!)! <=  self.bucketList.count + 1) { //if an integer that fits in constraints is inputted
                self.bucketList.insert(bucketItem!, at: Int(placeOnList!)! - 1) //add to bucket list
                self.printList() //print bucket list
            } else {
                //prints error message
                self.printToScreen("Bad input. Please input an integer between 1-\(self.bucketList.count + 1)")
            }
            
        }
        
        //the cancel action doing nothing
        let cancelAction = UIAlertAction(title: "Cancel", style: .cancel) { (_) in }
        
        //adding textfields to our dialog box
        alertController.addTextField { (textField) in
            textField.placeholder = "Enter bucket list item"
        }
        alertController.addTextField { (textField) in
            textField.placeholder = "Enter place on list"
        }
        
        //adding the action to dialogbox
        alertController.addAction(confirmAction)
        alertController.addAction(cancelAction)
        
        //finally presenting the dialog box
        self.present(alertController, animated: true, completion: nil)
        
    }
    
    //-------remove from bucket list-------------
    @IBAction func removeBucket(_ sender: UIButton) {
        
        //Creating UIAlertController and
        //Setting title and message for the alert dialog
        let alertController = UIAlertController(title: "Remove from Bucket List", message: "Enter the number of the list you'd like to remove (1-\(bucketList.count))", preferredStyle: .alert)
        
        //the confirm action taking the inputs
        let confirmAction = UIAlertAction(title: "Enter", style: .default) { (_) in
            
            var placeOnList: String?
            
            //getting the input values from user
            placeOnList = alertController.textFields?[0].text
            
            if(Int(placeOnList!) != nil && Int(placeOnList!)! > 0 && Int(placeOnList!)! <=  self.bucketList.count) { //if an integer that fits in constraints is inputted
                self.bucketList.remove(at: Int(placeOnList!)! - 1) //remove from list
                self.printList() //print bucket list
            } else {
                //prints error message
                self.printToScreen("Bad input. Please input an integer between 1-\(self.bucketList.count + 1)")
            }
        }
        
        //the cancel action doing nothing
        let cancelAction = UIAlertAction(title: "Cancel", style: .cancel) { (_) in }
        
        //adding textfields to our dialog box
        alertController.addTextField { (textField) in
            textField.placeholder = "Enter place on list"
        }
        
        //adding the action to dialogbox
        alertController.addAction(confirmAction)
        alertController.addAction(cancelAction)
        
        //finally presenting the dialog box
        self.present(alertController, animated: true, completion: nil)
    }


    //------------------compare bucket lists---------
    @IBAction func compareBucket(_ sender: UIButton){
        //variable with number of same bucket list items
        var numSame = 0

        printToScreen("\nMs Harris' bucket list is:")
        for (index, item) in teacherBucketList.enumerated() {
            printToScreen("   \(index + 1). \(item)")
        }
        
        for hers in teacherBucketList{
            for mine in bucketList {
                //if same bucket list item
                if hers == mine{
                    //add to number of same items
                    numSame += 1
                }
            }
        }
        //if there are same items
        if numSame > 0 {
            //print results of comparison in alert
            let alertController = UIAlertController(title: "Hey twin!", message: "I have \(numSame) bucket list item(s) in common with Ms. Harris.)", preferredStyle: .alert)
            let cancelAction = UIAlertAction(title: "Cancel", style: .cancel) { (_) in } //make cancel button
            alertController.addAction(cancelAction)
            self.present(alertController, animated: true, completion: nil)
            
            //if there aren't same items
        } else if numSame == 0 {
            //print message in alert
            let alertController = UIAlertController(title: "Sadly...", message: "We have nothing in common)", preferredStyle: .alert)
            let cancelAction = UIAlertAction(title: "Cancel", style: .cancel) { (_) in } //make cancel button
            alertController.addAction(cancelAction)
            self.present(alertController, animated: true, completion: nil)
        }
    }
    
        override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}
/*SUMMARY OF LEARNING:
 In Unit 2 we have learned some Swift basics including:
 Data types
 Control flow
 Collections
 Functions
 UIKit
 XCode
 Swift was easy to pick up in terms of syntax and everything, as it was straightforward and easy to read. However the most difficult part about completing this assignment was the UI. Apple devices have built in libraries to manage to user interface, and while it is very versatile and powerful there is a bit of a learning curve to connect the previous output to the console to outputting to the screen.
 Some other differences from Swift to other languages such as Java is the type safety and implicit type casting, which took some getting used to. Other things include the optional types, and structures. Swift structures are similar to those of cpp which made the learning curve very simple, however the values are passed by value rather then reference. This difference between classes and structures was slightly frustrating at first but I soon got the hang of it.
 Next steps:
 Since swift is similar to C and Cpp, I hope to review some of those languages to see the similarities which might help the concepts solidify. I also will experiment with the different capabilities unique to building iOS apps!
 */



