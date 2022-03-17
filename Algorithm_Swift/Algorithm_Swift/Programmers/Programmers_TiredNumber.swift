//
//  Programmers_TiredNumber.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/17.
//

import Foundation

var arr: [Int] = []
var m = 0
var visit: [Bool] = []
var d: [[Int]] = []
func solution(_ k:Int, _ dungeons:[[Int]]) -> Int {
    d = dungeons
    for i in 0..<dungeons.count{
        arr.append(i)
        visit.append(false)
    }
    let temp = Array(repeating: -1, count: dungeons.count)
    makePermutation(k, temp, 0)
    return m
}
func makePermutation(_ kk: Int, _ Temp: [Int], _ count: Int){
    var temp = Temp
    var k = kk
    if count == arr.count{
        for i in 0..<temp.count{
            if k < d[temp[i]][0]{
                return
            }
            k -= d[temp[i]][1]
            m = Swift.max(m, i+1)
        }
    }else{
        for i in 0..<arr.count{
            if !visit[i]{
                temp[count] = arr[i]
                visit[i] = true
                makePermutation(k, temp, count+1)
                visit[i] = false
            }
        }
    }
}
