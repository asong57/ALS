//
//  Programmers_Budget.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/29.
//

import Foundation

func solution_Budget(_ d:[Int], _ budget:Int) -> Int {
    var arr = d
    arr.sort()
    var sum = 0
    var count = 0
    for i in 0..<arr.count{
        sum += arr[i]
        if sum > budget{
            break
        }else{
            count += 1
        }
    }
    return count
}
