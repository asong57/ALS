//
//  Baekjoon2606.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/10.
//

import Foundation

func BJ2606(){
    let n = Int(readLine()!)!
    let m = Int(readLine()!)!
    var dict : [Int: [Int]] = [:]
    for _ in 0..<m{
        let line = readLine()!.split(separator: " ").map{ Int($0)! }
        if dict[line[0]] == nil {
            var arr = [line[1]]
            dict[line[0]] = arr
        }else{
            var arr = dict[line[0]]!
            arr.append(line[1])
            dict[line[0]] = arr
        }
        if dict[line[1]] == nil {
            var arr = [line[0]]
            dict[line[1]] = arr
        }else{
            var arr = dict[line[1]]!
            arr.append(line[0])
            dict[line[1]] = arr
        }
    }

    var visit: [Bool] = Array<Bool>(repeating: false, count: n+1)
    visit[1] = true
    var count = 0
    var arr: [Int] = [1]
    while(!arr.isEmpty){
        let num = arr.removeFirst()
        if let nums = dict[num] {
            for n in nums{
                if !visit[n]{
                    arr.append(n)
                    visit[n] = true
                    count += 1
                }
            }
        }
    }

    print(count)
}


// dictionary로 굳이 안 해도 그냥 array로 해도 되고 더 간단하다.
func BJpplus(){
    let M = 5
    var nodes: [[Int]] = []
    for _ in 0..<M {
        let inp = readLine()!.split(separator : " " ).map{Int(String($0))!}
        nodes[inp[0]].append(inp[1])
        nodes[inp[1]].append(inp[0])
    }
}
