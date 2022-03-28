//
//  Baekjoon2822.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/28.
//

import Foundation

func BJ2822(){
    var array: [Int] = []
    var dt: [Int:Int] = [:]
    for i in 1...8{
        let n = Int(readLine()!)!
        dt[n] = i
        array.append(n)
    }
    array.sort(by: >)
    var str = ""
    var sum = 0
    var answer: [String] = []
    for i in 0..<5{
        sum += array[i]
        answer.append(String(dt[array[i]]!))
    }
    answer.sort()
    for s in answer{
        str += s + " "
    }
    print(sum)
    print(str)
}
