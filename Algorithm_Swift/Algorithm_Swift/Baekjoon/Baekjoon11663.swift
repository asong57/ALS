//
//  Baekjoon11663.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/07.
//

import Foundation

func BJ11663(){
    let input = readLine()!.split(separator: " ").map{ Int($0)! }
    var arr = readLine()!.split(separator: " ").map{ Int($0)! }
    arr.sort()
    for _ in 0..<input[1]{
        let line = readLine()!.split(separator: " ").map{ Int($0)! }
        var left = 0
        var right = arr.count-1
        var mid = 0
        while left <= right {
            mid = (left + right)/2
            if arr[mid] > line[1] {
                right = mid - 1
            }else {
                left = mid + 1
            }
        }
        var rightIndex = right + 1
        left = 0
        right = arr.count - 1
        while left <= right {
            mid = (left + right)/2
            if arr[mid] < line[0] {
                left = mid + 1
            }else {
                right = mid - 1
            }
        }
        print(rightIndex - left)
    }
}
