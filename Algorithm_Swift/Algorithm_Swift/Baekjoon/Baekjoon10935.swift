//
//  Baekjoon10935.swift
//  Algorithm_Swift
//
//  Created by asong on 2021/11/02.
//

import Foundation

func viewDidLoad(){
    let line = readLine()
    let n = Int(line!)


    var i: Int = 0
    while i < n!{
        let input = readLine()!
        let inputArr = input.split(separator: ",")
        let a = Int(inputArr[0])!
        let b = Int(inputArr[1])!
        let answer = a+b
        print(answer)
        i+=1
    }
}

