//
//  Baekjoon16171.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/11.
//

import Foundation

func BJ16171(){
    let line = readLine()!
    var str = ""
    for c in line{
        if Int(String(c)) == nil {
            str += String(c)
        }
    }
    let key = readLine()!

    if str.contains(key){
        print(1)
    }else{
        print(0)
    }

    // filter 이용방법
    let filterText = String(line.filter { $0.isLetter })
}
