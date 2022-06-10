//
//  Baekjoon2193.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/06/10.
//

import Foundation

func BJ2193(){
    let N = Int(readLine()!)!

    var dp = Array(repeating: 0, count: N)
    dp[0] = 1

    if N == 1 || N == 2{
        print(1)
    }else{
        dp[1] = 1
        for i in 2...N-1{
            dp[i] = dp[i-1] + dp[i-2]
        }
        print(dp[N-1])
    }
}
