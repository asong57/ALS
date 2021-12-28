//
//  Baekjoon5565.swift
//  Algorithm_Swift
//
//  Created by asong on 2021/12/28.
//

import Foundation

func BJ5565(){
    var totalSum = Int(readLine()!)!

    for i in 0...8 {
        totalSum -= Int(readLine()!)!
    }
    print(totalSum)
}
