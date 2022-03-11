//
//  Baekjoon16439.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/11.
//

import Foundation

func BJ16439(){
    let input = readLine()!.split(separator: " ").map{ Int($0)! }
    var arr: [[Int]] = []
    for _ in 0..<input[0]{
        let line = readLine()!.split(separator: " ").map{ Int($0)! }
        arr.append(line)
    }
    var com: [Int] = []
    for i in 0..<input[1]{
        com.append(i)
    }
    var mmax = 0
    makeCombination(count: 0, start: 0, temps: [0,0,0])
    print(mmax)

    func makeCombination(count:Int,start:Int, temps:[Int]){
        var temp = temps
        if count == 3 {
            var sum = 0
            for i in 0..<arr.count {
                let m = Swift.max(arr[i][temp[0]] , Swift.max(arr[i][temp[1]], arr[i][temp[2]]))
                sum += m
            }
            mmax = Swift.max(sum, mmax)
        }else{
            var i = start
            while i < com.count{
                temp[count] = com[i]
                makeCombination(count: count+1, start: i, temps: temp)
                i += 1
            }
        }
    }

}
