//
//  Programmers_Disguise.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/01.
//

import Foundation

func solution_Disguise(_ clothes:[[String]]) -> Int {
    var answer = 0
    var dict : [String: Int] = [:]
    for arr in clothes{
        if dict[arr[1]] == nil{
            dict[arr[1]] = 1
        }else{
            dict[arr[1]] = dict[arr[1]]! + 1
        }
    }
    for key in dict.keys {
        if let count = dict[key] {
            answer = answer + (answer * count) + count
        }
    }
    return answer
}
