//
//  Baekjoon11441.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/30.
//

import Foundation

func BJ11441(){
    let n = Int(readLine()!)!
    let A = readLine()!.split(separator: " ").map{ Int($0)!}
    var sum: [Int] = [A[0]]
    for i in 1..<A.count{
        sum.append(sum[i-1] + A[i])
    }
    let M = Int(readLine()!)!
    for i in 0..<M{
        let range = readLine()!.split(separator: " ").map{Int($0)!}
        if range[0] - 2 < 0{
            print(sum[range[1]-1])
        }else{
            print(sum[range[1]-1] - sum[range[0]-2])
        }
    }

}
