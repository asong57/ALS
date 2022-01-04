//
//  Baekjoon2475.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/01/04.
//

import Foundation

func BJ2475(){
    let input = readLine()!
    let inputArr = input.split(separator: " ")
    var sum: Int = 0
    var number: Int
    for n in inputArr {
        number = Int(n)!
        number = number * number
        sum += number
    }
    print(sum % 10)
}
