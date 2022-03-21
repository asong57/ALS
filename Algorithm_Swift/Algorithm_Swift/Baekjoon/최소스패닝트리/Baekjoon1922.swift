//
//  Baekjoon1922.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/21.
//

import Foundation

func BJ1922(){
    let n = Int(readLine()!)!
    let M = Int(readLine()!)!
    var cArr:[computer] = []
    var parent: [Int] = []
    for _ in 0..<M{
        let line = readLine()!.split(separator: " ").map{ Int($0)! }
        cArr.append(computer(start: line[0], end: line[1], weight: line[2]))
    }

    for i in 0...n{
        parent.append(i)
    }

    cArr = cArr.sorted(by: {$0.weight < $1.weight} )

    var answer = 0
    for i in 0..<cArr.count{
        var com = cArr[i]
        if find(com.start) != find(com.end){
            answer += com.weight
            union(com.start, com.end)
        }
    }
    print(answer)
    
    func find(_ x: Int) -> Int{
        if x == parent[x]{
            return x
        }
        parent[x] = find(parent[x])
        return parent[x]
    }

    func union(_ xx: Int, _ yy: Int) {
        var x = xx
        var y = yy
        x = find(x)
        y = find(y)
        if x != y {
            parent[y] = x
        }
    }

    struct computer{
        var start: Int
        var end:Int
        var weight:Int
    }
}

