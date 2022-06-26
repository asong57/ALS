//
//  Baekjoon21318.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/06/26.
//

import Foundation

func BJ21318(){
    let N = Int(readLine()!)!
    var melody: [Int] = readLine()!.split(separator: " ").map{Int($0)!}

    var mistakes = Array(repeating: 0, count: N)
    for i in 1..<N{
        if melody[i] < melody[i-1]{
            mistakes[i-1] += 1
        }
    }
    var counts = Array(repeating: 0, count: N)
    counts[0] = mistakes[0]
    for i in 1..<N{
        counts[i] = mistakes[i] + counts[i-1]
    }
    let Q = Int(readLine()!)!
    for i in 0..<Q{
        let xy = readLine()!.split(separator: " ").map{Int($0)!}
        
        if xy[1] - 2 < 0{
            print(0)
            continue
        }
        if xy[0] - 2 >= 0{
            print(counts[xy[1]-2] -  counts[xy[0]-2])
        }else{
            print(counts[xy[1]-2] )
        }
    }
}
