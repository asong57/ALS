//
//  Programmers_TwoNumbers.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/01.
//

import Foundation

func solution_TwoNumbers(_ numbers:[Int]) -> [Int] {
    var i = 0
    var j = 1
    var arr: [Int] = []
    var sum = 0
    for i in 0..<numbers.count-1{
         j = i + 1
            while j < numbers.count{
                sum = numbers[i] + numbers[j]
                if !arr.contains(sum){
                    arr.append(sum)
                }
                 j += 1
        }
    }
    arr.sort()
    return arr
}
