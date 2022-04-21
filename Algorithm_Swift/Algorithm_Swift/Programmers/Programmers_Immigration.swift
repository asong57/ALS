//
//  Programmers_Immigration.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/21.
//

import Foundation

func solutionImmigration(_ n:Int, _ times:[Int]) -> Int64 {
    var time = times.sorted(by: <)
    var left: Int64 = 0
    var right: Int64 = Int64(n * time[time.count-1])
    var mid: Int64 = 0
    var min: Int64 = Int64.max
    while left <= right{
        mid = (left + right) / 2
        
        var count = 0
        for i in 0..<time.count{
            count += Int(mid) / time[i]
        }
        if count >= n{
            right = mid - 1
            min = Swift.min(min,mid)
        }else{
            left = mid + 1
        }
    }
    return min
}
