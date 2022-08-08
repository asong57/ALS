//
//  Baekjoon11659.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/08/08.
//

import Foundation

func BJ11659(){
    let nm = readLine()!.split(separator: " ").map{Int($0)!}
    let nums = readLine()!.split(separator: " ").map{Int($0)!}
    var sum = Array(repeating: 0, count: nm[0]+1)
    for i in 0..<nm[0]{
        sum[i+1] = sum[i] + nums[i]
    }
    for i in 0..<nm[1]{
        let ij = readLine()!.split(separator: " ").map{Int($0)!}
        print(sum[ij[1]] - sum[ij[0]-1])
    }
}
