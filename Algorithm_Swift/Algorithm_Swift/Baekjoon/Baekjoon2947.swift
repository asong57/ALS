//
//  Baekjoon2947.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/02/23.
//

import Foundation

func BJ2947(){
    var input = readLine()!.split(separator: " ").map{ Int($0)! }
    var check = input.reduce(""){String($0) + " " + String($1)}

    roop: while true {
        for i in 0..<4 {
            if input[i] > input[i+1]{
                let a = input[i]
                input[i] = input[i+1]
                input[i+1] = a
                check = input.reduce(""){String($0) + " " + String($1)}
                check = check.substring(from: check.index(check.startIndex, offsetBy: 1))
                print(check)
            }
        }
        if check == "1 2 3 4 5" {
            break roop
        }
    }
}
