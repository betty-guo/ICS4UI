//
//  ViewController.swift
//  CommonInputControls
//
//  Created by Betty Guo on 2018-04-07.
//  Copyright © 2018 Betty Guo. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var toggle: UISwitch!
    @IBOutlet weak var button: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        button.addTarget(self, action: #selector(buttonTapped(_:)),
            for: .touchUpInside)
    }

    @IBAction func respondToTap (_ sender: UITapGestureRecognizer){
        print (sender.location(in: view))
    }
   @IBAction func buttonTapped(_ sender: Any) {
        print ("Button was tapped!")
        if toggle.isOn {
            print("The switch is on!")
        } else {
            print("The switch is off.")
        }
    }
    @IBAction func textFilled(_ sender: UITextField) {
        print ("Oh yeah")
    }

    
    @IBAction func switchToggled(_ sender: UISwitch) {
        if sender.isOn{
            print("The switch is on!")
        } else {
            print("The switch is off.")
        }
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

