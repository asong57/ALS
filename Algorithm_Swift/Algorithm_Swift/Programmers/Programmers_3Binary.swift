//
//  Programmers_3Binary.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/05/11.
//

import Foundation

func solution_3Binary(_ n:Int) -> Int {
    var str = ""
    var n = n
    while n > 0{
        str += String(n%3)
        n /= 3
    }
    n = Int(str)!
    var answer = 0
    var count = 1
    while n > 0{
        var sum = (n % 10)
        for i in 1..<count{
            sum *= 3
        }
        answer += sum
        count += 1
        n /= 10
    }
    return answer
}
