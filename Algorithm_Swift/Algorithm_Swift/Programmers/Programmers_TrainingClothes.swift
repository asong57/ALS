//
//  Programmers_TrainingClothes.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/05/12.
//

import Foundation

func solution(_ n:Int, _ lost:[Int], _ reserve:[Int]) -> Int {
    var lost = lost
    var reserve = reserve
    var answer = n
    var lostNumber = lost.count
    reserve.sort()
    lost.sort()
    for i in 0..<lost.count{
        for j in 0..<reserve.count{
            if lost[i] == reserve[j]{
                lostNumber -= 1
                lost[i] = -1
                reserve[j] = -1
                break
            }
        }
    }
    for i in 0..<lost.count{
        for j in 0..<reserve.count{
            if lost[i] + 1 == reserve[j] || lost[i] - 1 == reserve[j]{
                lostNumber -= 1
                reserve[j] = -1
                break
            }
        }
    }
    answer -= lostNumber
    return answer
}
