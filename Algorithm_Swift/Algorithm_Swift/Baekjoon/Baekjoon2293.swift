//
//  Baekjoon2293.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/06/13.
//

import Foundation

func BJ2293(){
    let nk = readLine()!.split(separator: " ").map{Int($0)!}
    let N = nk[0]
    let K = nk[1]
    var dp = Array(repeating: 0, count: 10001)
    dp[0] = 1
    var coin: [Int] = []
    for i in 0..<N{
        let m = Int(readLine()!)!
        coin.append(m)
    }
    for i in 0..<N{
        for j in 1...K{
            if j >= coin[i]{
                dp[j] += dp[j-coin[i]]
                if dp[j] > Int(pow(2.0, 31.0)){ dp[j] = 0 }
            }
        }
    }
    print(dp[K])
}
