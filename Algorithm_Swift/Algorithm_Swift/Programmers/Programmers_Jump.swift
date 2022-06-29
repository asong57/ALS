//
//  Programmers_Jump.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/06/29.
//

import Foundation

func solution_Jump(_ n:Int) -> Int {
    var dp = Array(repeating: 0, count: n+1)
    dp[0] = 0
    dp[1] = 1
    if n == 1{
        return 1
    }
    dp[2] = 2
    if n >= 3{
        for i in 3...n{
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567
        }
    }
    return Int(dp[n])
}
