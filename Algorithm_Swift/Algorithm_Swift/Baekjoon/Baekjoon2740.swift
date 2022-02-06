//
//  Baekjoon2740.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/02/06.
//

import Foundation

func BJ2740(){
    var arrSizes = readLine()!.split(separator: " ").map{ Int($0)! }

    var arrA: [[Int]] = Array(repeating: Array(repeating: 0, count: arrSizes[1]), count: arrSizes[0])

    for i in 0..<arrSizes[0]{
        let input = readLine()!.split(separator: " ").map{ Int($0)! }
        for j in 0..<arrSizes[1]{
            arrA[i][j] = input[j]
        }
    }
    arrSizes = readLine()!.split(separator: " ").map{ Int($0)! }

    var arrB: [[Int]] = Array(repeating: Array(repeating: 0, count: arrSizes[1]), count: arrSizes[0])

    for i in 0..<arrSizes[0]{
        let input = readLine()!.split(separator: " ").map{ Int($0)! }
        for j in 0..<arrSizes[1]{
            arrB[i][j] = input[j]
        }
    }

    for i in 0..<arrA.count{
        var str = ""
        for k in 0..<arrSizes[1]{
            var sum: Int = 0
            for j in 0..<arrB.count{
                sum += arrA[i][j] * arrB[j][k]
            }
            str += String(sum) + " "
        }
        print(str)
    }
}

// 이차원 배열을 더 깔끔하게 만드는 풀이
func BJ2740plus(){
    let NM = readLine()!.split(separator: " ").map { Int(String($0))! }
    let N = NM[0], M = NM[1]
    var A = Array(repeating: [Int](), count: N)

    for i in 0..<N {
        A[i] = readLine()!.split(separator: " ").map { Int(String($0))! }
    }

    let MK = readLine()!.split(separator: " ").map { Int(String($0))! }
    let K = MK[1]
    var B = Array(repeating: [Int](), count: M)

    for i in 0..<M {
        B[i] = readLine()!.split(separator: " ").map { Int(String($0))! }
    }

    for i in 0..<N {
        for j in 0..<K {
            var sum = 0
            for k in 0..<M {
                sum += A[i][k] * B[k][j]
            }
            print("\(sum) ", terminator: "")
        }
        print("")
    }
}
