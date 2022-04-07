//
//  Programmers_Kim.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/07.
//

import Foundation

func solution_Kim(_ seoul:[String]) -> String {
    for i in 0..<seoul.count{
        if seoul[i] == "Kim"{
            return "김서방은 \(String(i))에 있다"
        }
    }
    return ""
}
