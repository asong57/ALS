//
//  Baekjoon1100.swift
//  Algorithm_Swift
//
//  Created by asong on 2021/12/06.
//

import Foundation

func BJ1100(){
    var count = 0
    for i in 0...7 {
        var line = readLine()
        var index = 0
        for j in line! {
            if j == "F" {
                if i % 2 == 0 && index % 2 == 0 {
                    count += 1
                }
                if i % 2 == 1 && index % 2 == 1 {
                    count += 1
                }
                
            }
            index += 1
        }
    }
    print(count)
}
