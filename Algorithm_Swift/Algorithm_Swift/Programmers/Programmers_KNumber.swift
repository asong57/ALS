//
//  Programmers_KNumber.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/06.
//

import Foundation

func solution_KNumber(_ array:[Int], _ commands:[[Int]]) -> [Int] {
    var answer: [Int] = []
    for c in 0..<commands.count{
        let i = commands[c][0] - 1
        let j = commands[c][1] - 1
        let k = commands[c][2] - 1
        var arr: [Int] = []
        for h in i...j{
            arr.append(array[h])
        }
        arr.sort()
        answer.append(arr[k])
    }
    return answer
}
