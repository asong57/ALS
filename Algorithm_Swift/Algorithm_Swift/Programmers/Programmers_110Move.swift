//
//  Programmers_110Move.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/06/14.
//

import Foundation

func solution_Move110(_ s:[String]) -> [String] {
    var answer: [String] = []
    for ss in s{
        var stack: [String] = []
        var add = ""
        for c in ss{
            if stack.count >= 2 && stack[stack.count-2] == "1" && stack[stack.count-1] == "1" && c == "0"{
                stack.removeLast()
                stack.removeLast()
                add += "110"
            } else{
                stack.append(String(c))
            }
        }
        var index = 0
        for i in stride(from: stack.count-1, through: 0, by: -1) {
            if stack[i] == "0" {
                index = i+1
                break
            }
        }
        stack.insert(add, at: index)
        answer.append(stack.joined())
    }
    
    return answer
}
