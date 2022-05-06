//
//  Programmers_WallTest.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/05/06.
//

import Foundation

func Programmers_WallTest(){
    var arr: [[Int]] = []
    var min = Int.max
    func solution(_ n:Int, _ weak:[Int], _ dist:[Int]) -> Int {
        arr = Array(repeating: Array(repeating: 0, count: weak.count), count: weak.count)
        setWeakArr(weak,n)
        for i in 1...dist.count{
            var visit = Array(repeating: false, count: dist.count)
            var temp = Array(repeating: 0, count: i)
            makePermutation(0, visit, temp, dist)
        }
        if min == Int.max{
            return -1
        }
        return min
    }
    func setWeakArr(_ weak:[Int], _ n: Int){
        for i in 0..<weak.count{
            for j in 0..<weak.count{
                var index = i + j
                if index >= weak.count{
                    arr[i][j] = weak[index - weak.count] + n
                }else{
                    arr[i][j] = weak[index]
                }
                
            }
        }
    }
    func makePermutation(_ current: Int, _ visit: [Bool], _ temp: [Int], _ dist: [Int]){
        var temp = temp
        var visit = visit
        if current == temp.count{
            checkAnswer(temp)
        }else{
            for i in 0..<dist.count{
                if !visit[i]{
                    visit[i] = true
                    temp[current] = dist[i]
                    makePermutation(current+1, visit, temp, dist)
                    visit[i] = false
                }
            }
        }
    }
    func checkAnswer(_ temp: [Int]){
        for i in 0..<arr.count{
            var k = 0
            var start = arr[i][0]
            for j in 0..<temp.count{
                while k < arr.count && temp[j] >= arr[i][k] - start{
                    k += 1
                }
                if k >= arr.count{
                    min = Swift.min(min, temp.count)
                }else{
                    start = arr[i][k]
                }
            }
        }
    }
}
