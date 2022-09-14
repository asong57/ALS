//
//  Programmers_IntSqrt.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/09/14.
//

import Foundation

func solution_IntSqrt(_ n:Int64) -> Int64 {
    var i = Int64(sqrt(Double(n)))
    if i * i == n {
        return (i + 1) * (i + 1)
    }
    return -1
}
