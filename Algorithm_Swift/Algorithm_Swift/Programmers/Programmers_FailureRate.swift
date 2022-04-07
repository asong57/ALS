//
//  Programmers_FailureRate.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/07.
//

import Foundation

func solution_FailureRate(_ N:Int, _ stages:[Int]) -> [Int] {
    var total = stages.count
    var stage = stages
    stage.sort()
    var answer: [(Int, Float)] = [(Int, Float)]()
    for i in 1...N{
        var sum = 0
        var count = 0
        while stage.first == i{
            sum += 1
            stage.removeFirst()
            count += 1
        }
        if total <= 0{
            answer.append((i, 0))
        }else{
            answer.append((i, Float(sum)/Float(total) ))
        }
        total -= count
    }
    answer = answer.sorted{ $0.1 > $1.1 }
    var list: [Int] = []
    for i in 0..<answer.count{
        list.append(answer[i].0)
    }
    return list
}
