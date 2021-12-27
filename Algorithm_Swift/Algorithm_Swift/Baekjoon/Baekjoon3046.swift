//
//  Baekjoon3046.swift
//  Algorithm_Swift
//
//  Created by asong on 2021/12/27.
//

import Foundation

func BJ3046(){
    let input = readLine()!
    let inputArr = input.split(separator: " ")
    let a = Int(inputArr[0])!
    let b = Int(inputArr[1])!
    print(2*b-a)
}
