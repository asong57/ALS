//
//  Baekjoon5523.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/02/15.
//

import Foundation

func BJ5523(){
    let n = Int(readLine()!)!
    var a = 0
    var b = 0
    for _ in 0..<n{
        let input = readLine()!.split(separator: " ").map{ Int($0)! }
        if input[0] > input[1] {
            a += 1
        }else if input[1] > input[0] {
            b += 1
        }
    }
    print("\(a) \(b)")
}
