//
//  Programmers_ConnectIsland.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/06/16.
//

import Foundation

func solution_ConnectIsland(_ n:Int, _ costs:[[Int]]) -> Int {
    var visit:[Bool] = Array(repeating: false, count: n)
    var map:[[(Int,Int)]] = Array(repeating: [], count: n)
    var q: [(Int,Int)] = []
    for i in 0..<costs.count{
        map[costs[i][0]].append((costs[i][1],costs[i][2]))
        map[costs[i][1]].append((costs[i][0],costs[i][2]))
    }
    q.append((0,0))
    var sum = 0
    while !q.isEmpty{
        q = q.sorted(by: {
            return $0.1 < $1.1
        })
        let now = q.removeFirst()
        if visit[now.0] == true{
            continue
        }
        visit[now.0] = true
        sum += now.1
        for i in 0..<map[now.0].count{
            if !visit[map[now.0][i].0]{
                q.append((map[now.0][i].0,map[now.0][i].1))
            }
        }
    }
    return sum
}
