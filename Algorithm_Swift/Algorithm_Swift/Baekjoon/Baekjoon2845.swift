//
//  Baekjoon2845.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/02/07.
//

import Foundation

func BJ2845(){
    let input = readLine()!.split(separator: " ").map{ Int($0)! }

    let arr = readLine()!.split(separator: " ").map{ Int($0)! }
    var answer = ""
    for i in 0...4{
        answer += String(arr[i]-input[0]*input[1] )+" "
    }
    print(answer)
}

// joined를 활용한 풀이
func BJ2845plus(){
    let area: Int = {
        let input = readLine()!.split(separator: " ").map{ Int($0)! }
        return input[0] * input[1]
    }()
    let input = readLine()!.split(separator: " ").map { String(Int($0)! - area) } .joined(separator: " ")
    print(input)
}
