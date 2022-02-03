//
//  Baekjoon9093.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/02/03.
//

import Foundation

func BJ9093(){
    let n: Int = Int(readLine()!)!
    var str: String = ""
    for _ in 0..<n {
        let input = readLine()!
        let arr = input.split(separator: " ")
        for word in arr {
            var wordStr = ""
            for c in word {
                wordStr = String(c) + wordStr
            }
            str += wordStr + " "
        }
        str += "\n"
    }

    print(str)


    // 다른 사람의 더 깔끔한 풀이
    let t = Int(readLine()!)!

    for _ in 0..<t {
        let words = readLine()!.split(separator: " ").map{String($0)}
        var arr = [String]()
        
        for word in words {
            var temp = ""
            for str in word.reversed() {
                temp += String(str)
            }
            arr.append(temp)
        }
        
        let result = arr.joined(separator: " ")
        print(result)
    }
}
