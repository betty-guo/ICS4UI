//
//  Dice.swift
//  BettyGU2A1Q2
//
//  Created by Betty Guo on 2018-04-09.
//  Copyright © 2018 Betty Guo. All rights reserved.
//

import Foundation
import UIKit

//--------function to create animated dice image---

func dice() -> [UIImage]{
    var images: [UIImage] = []
    for value in 0...5 {
        if let image = UIImage(named: "\(value).png" ){
            images.append(image)
        }
    }
    
    return images
}
