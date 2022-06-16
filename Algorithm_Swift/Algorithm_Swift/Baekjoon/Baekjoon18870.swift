//
//  Baekjoon18870.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/06/16.
//

import Foundation

func BJ18870(){
    let N = Int(readLine()!)!
    var nums = readLine()!.split(separator: " ").map{Int($0)!}
    var sortedNums = nums.sorted()
    var countDict: [Int:Int] = [:]
    var count = 0
    for i in 0..<sortedNums.count{
        if countDict[sortedNums[i]] == nil{
            countDict[sortedNums[i]] = count
            count += 1
        }
    }
    for i in 0..<nums.count{
        print(countDict[nums[i]]!, terminator: " ")
        // print(arr.map { String(dict[$0]!) }.joined(separator: " "))
    }
}
