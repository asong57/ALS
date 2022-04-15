//
//  Programmers_RaceRoad.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/15.
//

import Foundation

func solution_RaceRoad(_ board:[[Int]]) -> Int {
    let dx = [1,-1,0,0]
    let dy = [0,0,1,-1]
    var min = Int.max
    bfs(board)
    return min
    func bfs(_ board: [[Int]]){
        var arr: [(Int, Int, Int, Int)] = [(Int, Int, Int, Int)]()
        arr.append((0,0,-1,0))
        var map: [[Int]] = Array(repeating:Array(repeating:0, count: board[0].count), count: board.count)
        map[0][0] = 1
        while arr.count > 0{
            var now = arr.removeFirst()
            if now.0 == board.count-1 && now.1 == board.count - 1{
                min = map[board.count-1][board.count-1]
                continue
            }
            for i in 0..<4{
                let xx = now.0 + dx[i]
                let yy = now.1 + dy[i]
                var money = now.3
                if xx >= 0 && yy >= 0 && xx < board.count && yy < board.count && board[xx][yy] == 0{
                    if now.2 == -1 || ((i < 2) && (now.2 < 2)) || ((i >= 2) && (now.2 >= 2)){
                        money += 100
                    }else{
                        money += 600
                    }
                    
                    if map[xx][yy] == 0{
                        map[xx][yy] = money
                        arr.append((xx,yy,i,money))
                        continue
                    }
                    if map[xx][yy] >= money{
                        map[xx][yy] = money
                        arr.append((xx,yy, i, money))
                        continue
                    }
                }
            }
        }
    }

}
