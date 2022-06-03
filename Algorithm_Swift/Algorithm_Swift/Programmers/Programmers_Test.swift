//
//  Programmers_Test.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/06/03.
//

import Foundation

func solution_Test(_ answers:[Int]) -> [Int] {
    let arr1 = [1,2,3,4,5]
    let arr2 = [2,1,2,3,2,4,2,5]
    let arr3 = [3,3,1,1,2,2,4,4,5,5]
    var count1 = 0
    var count2 = 0
    var count3 = 0
    for i in 0..<answers.count{
        if arr1[i%arr1.count] == answers[i]{
            count1 += 1
        }
        if arr2[i%arr2.count] == answers[i]{
            count2 += 1
        }
        if arr3[i%arr3.count] == answers[i]{
            count3 += 1
        }
    }
    var max = 0
    var answer: [Int] = []
    if max < count1 {
        max = count1
        answer.append(1)
    }
    if max < count2{
        max = count2
        answer = [2]
    }else if max == count2{
        answer.append(2)
    }
    
    if max < count3{
        max = count3
        answer = [3]
    }else if max == count3{
        answer.append(3)
    }
    return answer
}
