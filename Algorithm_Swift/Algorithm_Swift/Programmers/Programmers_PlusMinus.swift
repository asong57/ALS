//
//  Programmers_PlusMinus.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/02/04.
//

import Foundation

func solution(_ absolutes:[Int], _ signs:[Bool]) -> Int {
    var sum: Int = 0
    for i in 0..<absolutes.count {
        switch signs[i] {
            case true: sum += absolutes[i]
            case false: sum -= absolutes[i]
        }
    }
    return sum
}
