//
//  CatAnimation.swift
//  BettyGU2A1Q4
//
//  Created by Betty Guo on 2018-04-10.
//  Copyright © 2018 Betty Guo. All rights reserved.
//

import Foundation
import UIKit

//--------function to create animated dice image---

func cat() -> [UIImage]{
    var images: [UIImage] = []
    for value in 0...5 {
        if let image = UIImage(named: "\(value).png" ){
            images.append(image)
        }
    }
    
    return images
}
