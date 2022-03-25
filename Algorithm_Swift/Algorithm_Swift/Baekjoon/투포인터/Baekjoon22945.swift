//
//  Baekjoon22945.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/25.
//

import Foundation

func BJ22945(){
    let N = Int(readLine()!)!
    let a = readLine()!.split(separator: " ").map{ Int($0)! }
    var start = 0
    var end = N-1
    var M = 0
    while start < end{
        M = Swift.max((Swift.min(a[start],a[end]) * (end-start-1)), M)
        if a[start] < a[end]{
            start += 1
        }else{
            end -= 1
        }
    }
    print(M)
}
