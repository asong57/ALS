//
//  Programmers_NonDestructiveBuilding.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/29.
//

import Foundation

func solution_NonDestructiveBuilding(_ board:[[Int]], _ skill:[[Int]]) -> Int {
    var sum = Array(repeating: Array(repeating: 0, count: board[0].count+1), count: board.count+1)
    for i in 0..<skill.count{
        let type = skill[i][0]
        let r1 = skill[i][1]
        let c1 = skill[i][2]
        let r2 = skill[i][3]
        let c2 = skill[i][4]
        var degree = skill[i][5]
        if type == 1{
            degree *= -1
        }
        sum[r1][c1] += degree
        sum[r2+1][c1] -= degree
        sum[r1][c2+1] -= degree
        sum[r2+1][c2+1] += degree
    }
    for j in 0..<board[0].count{
        for i in 1..<board.count{
            sum[i][j] += sum[i-1][j]
        }
    }
    for i in 0..<board.count{
        for j in 1..<board[0].count{
            sum[i][j] += sum[i][j-1]
        }
    }
    var answer = 0
    for i in 0..<board.count{
        for j in 0..<board[i].count{
            if board[i][j] + sum[i][j] >= 1{
                answer += 1
            }
        }
    }
    return answer
}
