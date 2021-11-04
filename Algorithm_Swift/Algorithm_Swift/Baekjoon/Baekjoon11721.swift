//
//  Baekjoon11721.swift
//  Algorithm_Swift
//
//  Created by asong on 2021/11/04.
//

import Foundation

func Baekjoon11721(){
    var input = readLine()!


    while input.count > 0 {
        if input.count < 10 {
            print(input)
            break
        }
        let endIdx: String.Index = input.index(input.startIndex, offsetBy: 9)
        var result = String(input[...endIdx])
        print(result)

        let startIdx: String.Index = input.index(input.startIndex, offsetBy: 10)
        input = String(input[startIdx...])
        if input.count < 10{
            print(input)
            break
        }
    }
}
