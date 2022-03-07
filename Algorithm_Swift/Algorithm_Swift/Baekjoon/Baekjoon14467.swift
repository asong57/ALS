//
//  Baekjoon14467.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/07.
//

import Foundation

func BJ14467(){
    let n = Int(readLine()!)!
    var arr = Array<Int>(repeating: 2, count: 11)
    var answer = 0
    for _ in 0..<n{
        let cow = readLine()!.split(separator: " ").map{ Int($0)! }
        if arr[cow[0]] == 2 {
            arr[cow[0]] = cow[1]
        }else if cow[1] != arr[cow[0]] {
            answer += 1
            arr[cow[0]] = cow[1]
        }
    }
    print(answer)
}
