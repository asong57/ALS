//
//  Programmers_Land.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/06/30.
//

import Foundation

func solution_Land(_ land:[[Int]]) -> Int{
    var answer = 0
    var land = land
    for i in 1..<land.count{
        land[i][0] += max(land[i-1][1], max(land[i-1][2], land[i-1][3]))
        land[i][1] += max(land[i-1][0], max(land[i-1][2], land[i-1][3]))
        land[i][2] += max(land[i-1][0], max(land[i-1][1], land[i-1][3]))
        land[i][3] += max(land[i-1][1], max(land[i-1][2], land[i-1][0]))
    }
    answer = max(max(land[land.count-1][0], land[land.count-1][1]) , max(land[land.count-1][2], land[land.count-1][3]))
    return answer
}
