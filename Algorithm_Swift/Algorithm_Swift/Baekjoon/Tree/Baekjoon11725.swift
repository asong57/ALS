//
//  Baekjoon11725.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/14.
//

import Foundation

func BJ11725(){
    let n = Int(readLine()!)!
    var arr: [[Int]] = Array(repeating: [], count: n+1)
    var visit: [Bool] = Array(repeating: false, count: n+1)
    for _ in 0..<n-1{
        let input = readLine()!.split(separator: " ").map{ Int($0)! }
        arr[input[0]].append(input[1])
        arr[input[1]].append(input[0])
    }
    var answer = Array(repeating: 0, count: n+1)
    dfs(1)
    for i in 2..<answer.count{
        print(answer[i])
    }
    func dfs(_ num: Int){
        visit[num] = true
        
        for child in arr[num]{
            if !visit[child]{
                dfs(child)
                answer[child] = num
            }
        }
    }
}
