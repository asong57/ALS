//
//  Programmers_GemsShopping.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/05.
//

import Foundation
func solution(_ gems:[String]) -> [Int] {
    var kindCount = 0
    var set: Set<String> = Set<String>()
    var dict: [String: Int] = [:]
    for g in gems{
        set.insert(g)
    }
    kindCount = set.count
    
    var left = 0
    var right = 0
    var min = Int.max
    var leftMin = Int.max
    while true{
        if dict.count == kindCount{
            if min > right - left{
                min = right - left
                leftMin = left
            }else if min == right - left{
                leftMin = Swift.min(left, leftMin)
            }
            dict[gems[left]] = dict[gems[left]]! - 1
            if dict[gems[left]]! <= 0{
                dict[gems[left]] = nil
            }
            left += 1
        }else if right == gems.count{
            break
        }else{
            if dict[gems[right]] == nil{
                dict[gems[right]] = 1
            }else{
                dict[gems[right]] = dict[gems[right]]! + 1
            }
            right += 1
        }
    }
    
    // dictionary 간단하게 사용하기
    dict[gems[left], default: 0] -= 1
    dict[gems[left], default: 0] += 1
    return [leftMin+1, leftMin+min]
}

