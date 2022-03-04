//
//  Baekjoon1969.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/04.
//

import Foundation

func BJ1969(){
    let input = readLine()!.split(separator: " ").map{ Int($0)! }
    var arr: [String] = []
    for i in 0..<input[0]{
        arr.append(readLine()!)
    }

    var dict: [String: Int] = [:]
    var answer = ""
    var sum = 0
    for k in 0..<input[1]{
        dict.removeAll()
        let index = arr[0].index(arr[0].startIndex, offsetBy: k)
        for i in 0..<arr.count{
            if dict[String(arr[i][index])] == nil {
                dict[String(arr[i][index])] = 1
            }else{
                dict[String(arr[i][index])]! += 1
            }
            
        }
        var max = Int.min
        var c: [String] = []
        for (key, value) in dict{
            if value > max {
                max = value
                c.removeAll()
                c.append(key)
            }else if value == max{
                c.append(key)
            }
        }
        
        c.sort()
        answer += c[0]
        sum += (input[0] - max)
    }
    print(answer)
    print(sum)
}
