//
//  Programmers_MinimumNumber.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/04.
//

import Foundation
func solution_MinimumNumber(_ A:[Int], _ B:[Int]) -> Int
{
    var ans = 0
    var a = A
    a.sort()
    var b = B
    b.sort()
    for i in 0..<a.count{
        ans += a[i] * b[a.count-i-1]
    }

    return ans
}
