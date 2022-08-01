//
//  Programmers_Divide1.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/08/01.
//

import Foundation

func solution_Divide1(_ n:Int) -> Int {
    var x = n-1
    var answer = 0
    while x >= 2 {
        if n % x == 1 {
            answer = x
        }
        x -= 1
    }
    return answer
}
