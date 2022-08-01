//
//  Programmers_PYCount.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/08/01.
//

import Foundation

func solution(_ s:String) -> Bool
{
    var ans:Bool = false
    var pCount = 0
    var yCount = 0
    var s = s.lowercased()
    for c in s{
        if c == "p" {
            pCount += 1
        }else if c == "y" {
            yCount += 1
        }
    }
    if pCount == 0 && yCount == 0 {
        return true
    }
    
    if pCount == yCount {
        return true
    } else {
        return false
    }
    return ans
}
