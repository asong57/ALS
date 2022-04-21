//
//  Programmers_FunctionDevelop.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/21.
//

import Foundation

func solution_develop(_ progresses:[Int], _ speeds:[Int]) -> [Int] {
    var cal: [Int] = []
    for i in 0..<progresses.count{
        if (100 - progresses[i]) % speeds[i] == 0{
            cal.append((100 - progresses[i]) / speeds[i])
        }else{
            cal.append((100 - progresses[i]) / speeds[i]+1)
        }
    }
    var before = cal[0]
    var answer: [Int] = []
    var count = 1
    for i in 1..<cal.count{
        if before >= cal[i]{
            count += 1
        }else{
            answer.append(count)
            count = 1
            before = cal[i]
        }
    }
    answer.append(count)
    
    return answer
}
