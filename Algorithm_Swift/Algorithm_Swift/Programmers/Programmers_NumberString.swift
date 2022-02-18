//
//  Programmers_NumberString.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/02/18.
//

import Foundation

func solution(_ s:String) -> Int {
    var str = s
    let numbers = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight","nine"]
    for i in 0..<numbers.count {
        if s.contains(numbers[i]) {
            str = str.replacingOccurrences(of: numbers[i], with: String(i))
        }
    }
 
    return Int(str)!
}
