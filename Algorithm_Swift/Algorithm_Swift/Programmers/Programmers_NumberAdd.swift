//
//  Programmers_NumberAdd.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/31.
//

import Foundation

func solution_NumberAdd(_ left:Int, _ right:Int) -> Int {
    var answer = 0
    for i in left...right{
        var count = 2
        if i == 2{
            answer += i
            continue
        }else if i == 1{
            answer -= 1
            continue
        }
        for j in 2..<i{
            if i % j == 0{
                count += 1
            }
        }
        if count % 2 == 0{
            answer += i
        }else{
            answer -= i
        }
    }
    return answer
}
