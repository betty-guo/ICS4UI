/*
 Unit 3-4 Assignment 1 Question 2
 Betty Guo
 Creation Date: 05/16/18
 Problem: Write a program that takes a group of numbers and sorts them
 
 REFERENCE:
 https://developer.apple.com/
 */

import UIKit

class ViewController: UIViewController {
    //--------------------DECLARE VARIABLES-------------------
    @IBOutlet weak var textScreen: UITextView! //to print to screen
    var currentText = "" //variable to hold screen output
    
    var inputArray = [Any]() //empty array to hold input
    var posIntArray = [Int]() //empty array to hold ints
    var posDoubleArray = [Double]() //empty array to hold doubles
    var negArray = [Any]() //empty array to hold negative numbers
    
    enum MyError: Error { //custom error
        case runtimeError(String)
    }
    
    //---------------------entry point---------------
    override func viewDidLoad() {
        super.viewDidLoad()
        
        //user prompt
        printToScreen( """
            Welcome to the Number Sorter!
            You enter in an array of positive or negative integers or real numbers. We sort and output the sorted results!
            """)
        printToScreen("Click the Input button to enter numbers")
        
    }
    
    //-------------------print array-------------
    func printArray(_ prompt: String, _ array: [Any]){
        printToScreen(prompt)
        for item in array {
            if let value = item as? Int{
                printToScreen("\(value)")
            }else{
                if let value2 = item as? Double{
                    printToScreen("\(value2)")
                }
            }
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
    
    //------------------take input and sort/output lists---------------------
    @IBAction func takeInput(_ sender: UIButton) {
        //sentinel
        var sentinel = true
        
        //flush arrays
        self.inputArray.removeAll()
        self.posIntArray.removeAll()
        self.posDoubleArray.removeAll()
        self.negArray.removeAll() 
        
        //Creating UIAlertController and
        //Setting title and message for the alert dialog
        let alertController = UIAlertController(title: "Input numbers", message: "Please enter a list of non-zero integers and real numbers, positive or negative, separated by commas (,) without spaces", preferredStyle: .alert)
        
        //the confirm action taking the inputs
        let confirmAction = UIAlertAction(title: "Enter", style: .default) { (_) in
            
            var item = [String?]() //array to hold input
            
            //getting the input values from user
            item = (alertController.textFields?[0].text)!.components(separatedBy: ",") //split and store input
            
            //-----------sort into different arrays----
            do{
                for number in item{
                    if let value = Int(number!){
                        if value < 0{
                            self.negArray.append(value)
                        }else{
                            if value > 0{
                                self.posIntArray.append(value)
                            }else{
                                throw MyError.runtimeError("Cannot enter zero") //zero
                            }
                        }
                    }else{
                        if let value2 = Double(number!){
                            if value2 < 0{
                                self.negArray.append(value2)
                            }else{
                                if value2 > 0{
                                    self.posDoubleArray.append(value2)
                                }else{
                                    throw MyError.runtimeError("Bad input. Please enter a list of non-zero integers and real numbers, positive or negative, separated by commas (,) without spaces") //improper input
                                }
                            }
                        }else{
                            throw MyError.runtimeError("Bad input. Please enter a list of non-zero integers and real numbers, positive or negative, separated by commas (,) without spaces") //improper input
                        }
                    }
                }
            }catch{
                self.printToScreen("Bad input. Please enter a list of non-zero integers and real numbers, positive or negative, separated by commas (,) without spaces")
                sentinel = false
            }
            
            
            //------------print arrays to screen-------
            if (sentinel){
                self.printToScreen("The numbers you entered: ")
                for value in item {
                    self.printToScreen("\(value!)")
                }
                self.printArray("Positive Integers: ", self.posIntArray)
                self.printArray("Positive Real Numbers: ", self.posDoubleArray)
                self.printArray("Negative Numbers: ", self.negArray)
            }
        }
        
        //the cancel action doing nothing
        let cancelAction = UIAlertAction(title: "Cancel", style: .cancel) { (_) in }
        
        //adding textfields to our dialog box
        alertController.addTextField { (textField) in
            textField.placeholder = "Enter numbers"
        }
        
        //adding the action to dialogbox
        alertController.addAction(confirmAction)
        alertController.addAction(cancelAction)
        
        //finally presenting the dialog box
        self.present(alertController, animated: true, completion: nil)
        
    }
    
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    
}
