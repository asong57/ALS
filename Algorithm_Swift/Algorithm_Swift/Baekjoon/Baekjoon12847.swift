//
//  Baekjoon12847.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/06/17.
//

import Foundation

func BJ12847(){
    let nm = readLine()!.split(separator: " ").map{Int($0)!}
    let profit = readLine()!.split(separator: " ").map{Int($0)!}
    var i = 0
    var maxProfit = 0
    var a: [Int] = Array(repeating: 0, count: nm[0]+1)
    for i in 1..<a.count{
        a[i] = a[i-1]+profit[i-1]
    }
    for i in nm[1]..<a.count{
        var sum = a[i] - a[i-nm[1]]
        maxProfit = Swift.max(maxProfit, sum)
    }
    print(maxProfit)
}
