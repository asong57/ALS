//
//  Baekjoon1120.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/05.
//

import Foundation

func BJ1120(){
    let strs = readLine()!.split(separator: " ")
    let a = strs[0]
    let b = strs[1]
    var count = 0
    var answer = Int.max
    for j in 0...(b.count-a.count){
        count = 0
        for i in 0..<a.count{
            if a[a.index(a.startIndex, offsetBy: i)] != b[b.index(b.startIndex, offsetBy: i+j)]{
                count += 1
            }
        }
        answer = Swift.min(answer, count)
    }
    print(answer)
}
