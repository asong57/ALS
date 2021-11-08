//
//  Baekjoon5597.swift
//  Algorithm_Swift
//
//  Created by asong on 2021/11/08.
//

import Foundation

func Baekjoon5597(){
    var students = [Int]()
    for i in 0..<28{
        let line = readLine()!
        var n = Int(line)
        students.append(n!)
    }

    for i in 1..<31{
        if !students.contains(i) {
            print(i)
        }
    }
}
