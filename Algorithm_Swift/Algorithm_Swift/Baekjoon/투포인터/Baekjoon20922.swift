//
//  Baekjoon20922.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/16.
//

import Foundation

func BJ20922(){
    let num = readLine()!.split(separator: " ").map{ Int($0)! }
    let arr = readLine()!.split(separator: " ").map{ Int($0)! }
    let k = num[1]
    let n = num[0]
    var l = 0
    var r = 0
    var m = 0
    var limit = Array(repeating: 0, count: 100001)
    while l <= r {
        if limit[arr[r]] < k{
            limit[arr[r]] += 1
            r += 1
        }else if limit[arr[r]] == k {
            limit[arr[l]] -= 1
            l += 1
        }
        m = Swift.max(m, r-l)
        if r == n {
            break
        }
    }
    print(m)
}
