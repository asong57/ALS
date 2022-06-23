//
//  Baekjoon14502.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/06/23.
//

import Foundation

func BJ14502(){
    let nm = readLine()!.split(separator: " ").map{Int($0)!}
    let N = nm[0]
    let M = nm[1]
    var map:[[Int]] = Array(repeating: [], count: N)
    for i in 0..<N{
        let mapLine: [Int] = readLine()!.split(separator: " ").map{Int($0)!}
        map[i].append(contentsOf: mapLine)
    }
    var answerCount = 0

    func dfs(_ depth: Int){
        if depth == 3{
            bfs()
            return
        }else{
            for i in 0..<N{
                for j in 0..<M{
                    if map[i][j] == 0{
                        map[i][j] = 1
                        dfs(depth+1)
                        map[i][j] = 0
                    }
                }
            }
        }
    }
    func bfs(){
        let dx = [0,1,0,-1]
        let dy = [1,0,-1,0]
        var q: [(Int,Int)] = []
        var temp = map
        var visit = Array(repeating: Array(repeating: false, count: M), count: N)
        for i in 0..<N{
            for j in 0..<M{
                if map[i][j] == 2{
                    q.append((i,j))
                }
            }
        }
        while !q.isEmpty{
            let now = q.removeFirst()
            for i in 0..<4{
                let xx = now.0 + dx[i]
                let yy = now.1 + dy[i]
                if xx >= 0 && yy >= 0 && xx < N && yy < M && !visit[xx][yy] && temp[xx][yy] == 0{
                    temp[xx][yy] = 2
                    visit[xx][yy] = true
                    q.append((xx,yy))
                }
            }
        }
        var answer = 0
        for i in 0..<N{
            for j in 0..<M{
                if temp[i][j] == 0{
                    answer += 1
                }
            }
        }
        answerCount = Swift.max(answer, answerCount)
    }

    dfs(0)
    print(answerCount)

}

