//
//  Programmers_HIndex.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/05/24.
//

import Foundation

func solution(_ citations:[Int]) -> Int {
    var paper = citations
    paper.sort()
    let last = paper[paper.count-1]
    var answer = 0
    for i in 0..<last{
        var count = 0
        for p in paper{
            if p >= i{
                count += 1
            }
        }
        if count >= i && paper.count - count <= i && i > answer{
            answer = i
        }
    }
    return answer
}
