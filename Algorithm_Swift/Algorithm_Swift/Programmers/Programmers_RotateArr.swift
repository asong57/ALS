//
//  Programmers_RotateArr.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/11.
//

import Foundation

func solution(_ rows:Int, _ columns:Int, _ queries:[[Int]]) -> [Int] {
    var arr = Array(repeating: Array<Int>(repeating:0, count: columns+1), count: rows+1)
    for i in 1...rows {
        for j in 1...columns{
            arr[i][j] = (i-1)*columns + j
        }
    }
    let origin = arr
    var answer: [Int] = []
    for i in 0..<queries.count{
        let ax = queries[i][0]
        let ay = queries[i][1]
        let bx = queries[i][2]
        let by = queries[i][3]
        let start = arr[ax][ay]
        var minValue = Int.max
        
        var x = ax+1
        var y = ay
        while(x <= bx){
            arr[x-1][y] = arr[x][y]
            minValue = min(minValue, arr[x][y])
            x += 1
        }
        
        x = bx
        y = ay + 1
        while(y <= by){
            arr[x][y-1] = arr[x][y]
            minValue = min(minValue, arr[x][y])
            y += 1
        }
        
        x = bx - 1
        y = by
        while(x >= ax){
            arr[x+1][y] = arr[x][y]
            minValue = min(minValue, arr[x][y])
            x -= 1
        }
        
        x = ax
        y = by - 1
        while (y > ay){
            arr[x][y+1] = arr[x][y]
            minValue = min(minValue, arr[x][y])
            y -= 1
        }
        arr[x][y+1] = start
        minValue = min(minValue, arr[x][y+1])
        answer.append(minValue)
    }

    return answer
}
