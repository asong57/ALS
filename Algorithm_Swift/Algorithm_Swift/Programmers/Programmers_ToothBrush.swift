//
//  Programmers_ToothBrush.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/14.
//

import Foundation

func solution_ToothBrush(_ enroll:[String], _ referral:[String], _ seller:[String], _ amount:[Int]) -> [Int] {
    var result: [String: Int] = [:]
    var parent: [String: String] = [:]
    for i in 0..<referral.count{
        parent[enroll[i]] = referral[i]
        result[enroll[i]] = 0
    }
    l: for i in 0..<seller.count{
        var money = amount[i] * 100 * 9 / 10
        result[seller[i]]! += money
        money = amount[i] * 100 * 1 / 10
        if money < 1 {
            result[seller[i]]! += money
            continue l
        }
        var recommender = parent[seller[i]]
        var left = 0
        while recommender != nil{
            left = money * 1 / 10
            if recommender == "-"{
                continue l
            }
            if left < 1{
                result[recommender!]! += money
                continue l
            }
            result[recommender!]! += money - left
            money = money * 1 / 10
            recommender = parent[recommender!]
        }
    }
    var answer: [Int] = []
    for i in 0..<enroll.count{
        answer.append(result[enroll[i]] ?? 0)
    }
    return answer
}
