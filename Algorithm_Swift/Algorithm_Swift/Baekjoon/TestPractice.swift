//
//  TestPractice.swift
//  Algorithm_Swift
//
//  Created by asong on 2021/12/29.
//

import Foundation

func P1(){
    var num: Int = 0
    var n: Int = 32
    for i in 0...Int.max {
        var sum: Int = 0
        num = i
        while num > 0 {
            sum += num % 10
            num = num / 10
        }
        if sum == n {
            print(i)
            break;
        }
    }
}
