//
//  Programmers_Network.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/24.
//

import Foundation

func Programmers_Network(){
    var visit: [Bool] = []
    var list: [[Int]] = []
    var answer = 0
    func solution(_ n:Int, _ computers:[[Int]]) -> Int {
        visit = Array(repeating:false, count: n)
        list = Array(repeating: [], count: n)
        for i in 0..<computers.count{
            for j in 0..<computers[0].count{
                if computers[i][j] == 1 && i != j{
                    list[i].append(j)
                }
            }
        }
        for i in 0..<computers.count{
            if !visit[i]{
                bfs(i)
            }
        }
        return answer
    }
    func bfs(_ n: Int){
        visit[n] = true
        var q = [n]
        while !q.isEmpty{
            let now = q.removeFirst()
            for i in 0..<list[now].count{
                if !visit[list[now][i]]{
                    q.append(list[now][i])
                    visit[list[now][i]] = true
                }
            }
        }
        answer += 1
    }
}
