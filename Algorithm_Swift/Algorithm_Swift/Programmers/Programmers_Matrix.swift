//
//  Programmers_Matrix.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/06/28.
//

import Foundation

func solution_Matrix(_ arr1:[[Int]], _ arr2:[[Int]]) -> [[Int]] {
    var answer = Array(repeating: Array(repeating: 0, count: arr2[0].count), count: arr1.count)
    for i in 0..<arr1.count{
        for k in 0..<arr2[0].count{
            for j in 0..<arr1[0].count{
                answer[i][k] += arr1[i][j] * arr2[j][k]
            }
        }
    }
    return answer
}
