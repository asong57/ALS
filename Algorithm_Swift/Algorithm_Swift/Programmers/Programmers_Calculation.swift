//
//  Programmers_Calculation.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/02/04.
//

import Foundation

func solution(_ a:[Int], _ b:[Int]) -> Int {
    var answer: Int = 0
    for i in 0..<a.count {
        answer += a[i] * b[i]
    }
    return answer
}
