//
//  Movie.swift
//  BettyGU2A1Q1
//
//  Created by Betty Guo on 2018-04-09.
//  Copyright © 2018 Betty Guo. All rights reserved.
//

import Foundation
import UIKit

// Structure to hold movie rating and image
struct Movie{
    var rating: Double
    var image: UIImage?
    
    init(rating: Double, image: String) {
        self.rating = rating
        if let myImage = UIImage(named: image){ //if photo path exists
            self.image = myImage
        }
    }
}
