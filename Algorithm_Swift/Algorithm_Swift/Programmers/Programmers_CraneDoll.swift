//
//  Programmers_CraneDoll.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/10.
//

import Foundation

func solution(_ board:[[Int]], _ moves:[Int]) -> Int {
    var dict: [Int: [Int]] = [:]
    for j in 0..<board[0].count {
        for i in 0..<board.count{
            if board[i][j] == 0 {
                continue
            }
            if dict[j+1] == nil {
                var arr: [Int] = []
                arr.append(board[i][j])
                dict[j+1] = arr
            }else{
                var arr: [Int] = dict[j+1]!
                arr.append(board[i][j])
                dict[j+1] = arr
            }
        }
    }
    var count = 0
    var answer: [Int] = [0]
    for m in moves {
        if dict[m] != nil {
            var arr = dict[m]!
            if arr.count > 0 {
                 let n = arr.removeFirst()
                
                 dict[m] = arr
                if answer[answer.count-1] == n{
                    count += 2
                    answer.removeLast()
                }else{
                    answer.append(n)
                }
            }
        }
    }
    return count
}

// 더 깔끔한 풀이
func solutionPlus(_ board:[[Int]], _ moves:[Int]) -> Int {
    var count = 0
    var stacks: [[Int]] = Array(repeating: [], count: board.count)
    var bucket: [Int] = []

    board.reversed().forEach {
        $0.enumerated().forEach {
            if $0.1 != 0 {
                stacks[$0.0].append($0.1)
            }
        }
    }

    moves.forEach {
        if let doll = stacks[$0-1].popLast() {
            if let last = bucket.last, last == doll {
                bucket.removeLast(1)
                count += 2
            } else {
                bucket.append(doll)
            }
        }
    }

    return count
}
