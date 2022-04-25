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

func solution_NumberString2(_ s:String) -> Int {
    var s = s
    s = s.replacingOccurrences(of: "zero", with: "0")
    s = s.replacingOccurrences(of: "one", with: "1")
    s = s.replacingOccurrences(of: "two", with: "2")
    s = s.replacingOccurrences(of: "three", with: "3")
    s = s.replacingOccurrences(of: "four", with: "4")
    s = s.replacingOccurrences(of: "five", with: "5")
    s = s.replacingOccurrences(of: "six", with: "6")
    s = s.replacingOccurrences(of: "seven", with: "7")
    s = s.replacingOccurrences(of: "eight", with: "8")
    s = s.replacingOccurrences(of: "nine", with: "9")
    return Int(s)!
}
