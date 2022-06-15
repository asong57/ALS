//
//  Programmers_LongestPallinDrome.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/06/15.
//

import Foundation

func solution_LongestPallinDrome(_ s:String) -> Int {
    var s = s.map{String($0)}
    var i = s.count
    var answer = 1
    while i >= 1{
        l: for j in 0...s.count-i{
            var size = 0
            if i % 2 == 0{
                size = i/2
            }else if i >= 2{
                size = i - 2
            }
            for k in 0..<size{
                if s[j+k] != s[j+i-1-k]{
                    continue l
                }
            }
            if answer < i{
                answer = i
            }
        }
        if answer != 1{
            return answer
        }
        i -= 1
    }
    return answer
}
