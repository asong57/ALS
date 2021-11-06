//
//  Baekjoon2440.swift
//  Algorithm_Swift
//
//  Created by asong on 2021/11/06.
//

import Foundation

func Baekjoon2440(){
    let line = readLine()
    var n = Int(line!)

    while n! >= 0 {
        for i in 0..<n!{
            print("*", terminator: "")
        }
        print()
        n! -= 1
    }
}
