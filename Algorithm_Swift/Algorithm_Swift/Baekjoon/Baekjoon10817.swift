//
//  Baekjoon10817.swift
//  Algorithm_Swift
//
//  Created by asong on 2021/11/03.
//

import Foundation

func viewDidLoad(){
    let input = readLine()!
    let inputArr = input.split(separator: " ")
    let a = Int(inputArr[0])!
    let b = Int(inputArr[1])!
    let c = Int(inputArr[2])!
    var min: Int
    var min2: Int
    if a < b {
        if b < c{
            print(b)
        }else if a < c{
            print(c)
        }else{
            print(a)
        }
    }else{
        if a < c{
            print(a)
        }else if b < c{
            print(c)
        }else{
            print(b)
        }
    }
}

