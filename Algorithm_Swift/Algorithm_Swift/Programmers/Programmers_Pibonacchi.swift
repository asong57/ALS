//
//  Programmers_Pibonacchi.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/06/24.
//

import Foundation

func solution_Pibonacchi(_ n:Int) -> Int {
    var dp = Array(repeating: 0, count: n+1)
    dp[0] = 0
    dp[1] = 1
    for i in 2...n{
        dp[i] = (dp[i-1] + dp[i-2]) % 1234567
    }
    return dp[n]
}
