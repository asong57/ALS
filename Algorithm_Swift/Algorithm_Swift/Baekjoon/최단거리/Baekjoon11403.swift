//
//  Baekjoon11403.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/18.
//

import Foundation

func BJ11403(){
    let n = Int(readLine()!)!
    var a: [[Int]] = Array(repeating: [0], count: n)
    var v = Array(repeating: Array(repeating: false, count: n), count: n)
    for i in 0..<n{
        let line = readLine()!.split(separator: " ").map{ Int($0)! }
        a[i] = line
    }
    for k in 0..<n{
        for i in 0..<n{
            for j in 0..<n{
                if a[i][k] == 1 && a[k][j] == 1{
                    a[i][j] = 1
                }
            }
        }
    }
    for i in 0..<a.count{
        var str = ""
        for j in 0..<a[0].count{
            str += "\(a[i][j]) "
        }
        print(str)
    }

    // 플로이드 와샬 알고리즘
    // i에서 j로 가는 경로가 있는가?
    // 모든 정점에서 모든 정점까지의 최단 거리
    // arr[i][k] == 1 && arr[k][j] == 1 이면 arr[i][j] = 1
}
