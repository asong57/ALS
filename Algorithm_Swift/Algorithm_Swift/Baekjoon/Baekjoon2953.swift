//
//  Baekjoon2953.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/01/05.
//

import Foundation

func BJ2953(){
    var max : Int = 0
    var sum: Int = 0
    var winner : Int = 0
    for i in 1...5 {
        var arr = readLine()!.split(separator: " ")
        sum = 0
        for n in arr{
            sum += Int(n)!
        }
        if max < sum {
            max = sum
            winner = i
        }
    }
    print("\(winner) \(max)")
}
