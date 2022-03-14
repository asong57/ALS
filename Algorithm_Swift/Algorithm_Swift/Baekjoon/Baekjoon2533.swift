//
//  Baekjoon2533.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/14.
//

import Foundation

func BJ2533(){
    var n = Int(readLine()!)!
    var arr: [[Int]] = Array(repeating: [], count: n+1)
    for _ in 0..<n-1{
        let input = readLine()!.split(separator: " ").map { Int($0)! }
        arr[input[0]].append(input[1])
        arr[input[1]].append(input[0])
    }
    var visit: [Bool] = Array(repeating: false, count: n+1)
    var dp: [[Int]] = Array(repeating: Array(repeating: 0, count: 2), count: n+1)
    dfs(1)
    print(min(dp[1][0], dp[1][1]))

    func dfs(_ num: Int){
        visit[num] = true
        dp[num][0] = 0
        dp[num][1] = 1
        
        for child in arr[num] {
            if !visit[child]{
                dfs(child)
                dp[num][0] += dp[child][1]
                dp[num][1] += min(dp[child][0], dp[child][1])
            }
        }
    }
}
