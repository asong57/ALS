//
//  Programmers_TaxiFare.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/05/03.
//

import Foundation

var list: [[Int]] = []
func solution_TaxiFare(_ n:Int, _ s:Int, _ a:Int, _ b:Int, _ fares:[[Int]]) -> Int {
    list = Array(repeating:Array(repeating:0, count:n+1), count: n+1)
    for i in 0..<fares.count{
        list[fares[i][0]][fares[i][1]] = fares[i][2]
        list[fares[i][1]][fares[i][0]] = fares[i][2]
    }
    let intMax = 200 * 100000 + 1;
    var arrA = Array(repeating: intMax, count: n+1)
    arrA = dijkstra(a, arrA)
    var arrB = Array(repeating: intMax, count: n+1)
    arrB = dijkstra(b, arrB)
    var arrS = Array(repeating: intMax, count: n+1)
    arrS = dijkstra(s, arrS)
    var answer = Int.max
    for i in 1...n{
        answer = min(answer, arrA[i]+arrB[i]+arrS[i])
    }
    return answer
}

func dijkstra(_ n: Int, _ arr: [Int]) -> [Int]{
    var cost = arr
    var q: [(Int, Int)] = [(Int,Int)]()
    q.append((n, 0))
    cost[n] = 0
    
    while q.count > 0{
        q = q.sorted{ $0.1 < $1.1}
        var now = q.removeFirst()
        let nIndex = now.0
        let nCost = now.1
        
        if cost[nIndex] < nCost{
            continue
        }
        
        l: for i in 1..<list[nIndex].count{
            let iCost = cost[i]
            if list[nIndex][i] == 0{
                continue l
            }
            if iCost > cost[nIndex] + list[nIndex][i]{
                cost[i] = cost[nIndex] + list[nIndex][i]
                q.append((i, cost[i]))
            }
        }
    }
    return cost
}
