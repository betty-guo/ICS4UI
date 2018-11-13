/*
 Unit 3-4 Assignment 1 Question 3
 Betty Guo
 Creation Date: 05/18/18
 Problem: Create a tip calculator app
 
 REFERENCE:
 https://developer.apple.com/
 */
import UIKit
import Foundation

class ViewController: UIViewController {
    
    //-----------------------DECLARE VARIABLES----------------------
    var billText = "30"
    var tipText = "4.5"
    var totalText = "34.5"
    
    @IBOutlet weak var billAmountLabel: UILabel!
    @IBOutlet weak var percAmountLabel: UILabel!
    @IBOutlet var adjustButtons: [UIButton]!
    @IBOutlet weak var tipAmountLabel: UILabel!
    @IBOutlet weak var totalAmountLabel: UILabel!
    
    //load views
    override func viewDidLoad() {
        super.viewDidLoad()
        updateUI()
        //load UI elements
        // Do any additional setup after loading the view, typically from a nib.
    }

    //loads and updates all values
    func updateUI(){
        //rounding and convert to currency
        let formatter = NumberFormatter()
        formatter.numberStyle = .currency
        formatter.locale = NSLocale.current
        
        //convert values to numbers
        if let value = Double(billText){
            tipText = String(value * (Double(percAmountLabel.text!)!/100))
            totalText = String(value + Double(tipText)!)
        }
        //update UI elements
        billAmountLabel.text = formatter.string(from: Double(billText)! as NSNumber)
        tipAmountLabel.text = formatter.string(from: Double(tipText)! as NSNumber)
        totalAmountLabel.text = formatter.string(from: Double(totalText)! as NSNumber)
        
    }
    //increments tip amount
    @IBAction func adjustButtonTapped(_ sender: UIButton) {
        if sender.title(for: .normal)! == "-"{
            percAmountLabel.text = String(Int(percAmountLabel.text!)!-1)
        }
        if sender.title(for: .normal)! == "+"{
            percAmountLabel.text = String(Int(percAmountLabel.text!)!+1)
        }
        updateUI()
    }
    
    //adds number tapped to bill amount
    @IBAction func numberTapped(_ sender: UIButton) {
        billText += sender.title(for: .normal)!
        updateUI()
    }
    
    //sets tip percent to 15
    @IBAction func percentReset(_ sender: UIButton) {
        percAmountLabel.text = "15"
        updateUI()
    }
    
    //deletes one off number
    @IBAction func backTapped(_ sender: Any) {
        if let index = billText.index(billText.endIndex, offsetBy: -1, limitedBy: billText.startIndex) {
            billText.remove(at: index)
            if billText == ""{
                billText = "0"
            }
        }
        updateUI()
    }
    //clears bill back to zero
    @IBAction func clearTapped(_ sender: Any) {
        billText = "0"
        updateUI()
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

