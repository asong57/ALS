//
//  Programmers_MaxMin.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/07/01.
//

import Foundation

func solution_MaxMin(_ s:String) -> String {
    var str = s.split(separator: " ").map{Int($0)!}
    str.sort()
    let answer = String(str[0]) + " " + String(str[str.count-1])
    return answer
}
