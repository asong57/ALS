//
//  Programmers_FindPrimeNumber.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/03.
//

import Foundation

func solution(_ n:Int) -> Int {
    var answer: Int = 1
    if n == 2{
        return 1
    }
    l: for i in 3...n{
        if i % 2 == 0 {
            continue;
        }
        var j: Int = 3
        let s = Int(sqrt(Float(i)))
        while j <= s {
            if i % j == 0{
                continue l;
            }
            j += 2
        }
        answer += 1
    }
    return answer
}
