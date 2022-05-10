//
//  Programmers_DartGame.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/05/10.
//

import Foundation
func solution_DartGame(_ dartResult:String) -> Int {
    var num = ""
    var sum = 0
    var arr = [0,0,0]
    var i = 0
    for s in dartResult{
        if s.isNumber{
            num += String(s)
        }else{
            if s == "*"{
                if i > 1{
                    arr[i-2] *= 2
                    arr[i-1] *= 2
                }else{
                    arr[i-1] *= 2
                }
                continue
            }else if s == "#"{
                arr[i-1] *= -1
                continue
            }
            
            let n = Int(num)!
            arr[i] = n
            if s == "D"{
                arr[i] = n * n
            }else if s == "T"{
                arr[i] = n * n * n
            }
            num = ""
            i += 1
        }
    }
    var answer = arr[0] + arr[1] + arr[2]
    return answer
}
