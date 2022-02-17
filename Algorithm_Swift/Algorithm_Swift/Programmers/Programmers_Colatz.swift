//
//  Programmers_Colatz.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/02/17.
//

import Foundation


func solution_Colatz(_ num:Int) -> Int {
    var n = num
    if n == 1 {
        return 0
    }
    for i in 1...500{
        if n % 2 == 0{
            n /= 2
        }else{
            n = n*3 + 1
        }
        if n == 1 {
            return i
        }
    }
    return -1
}
