//
//  Baekjoon7576.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/25.
//

import Foundation

func BJ7576(){
    var input = readLine()!.split(separator: " ").map{ Int($0)! }
    let N = input[0]
    let M = input[1]
    let dx = [0,1,0,-1]
    let dy = [1,0,-1,0]
    var a: [[Int]] = Array(repeating: [], count: M)
    var v = Array(repeating:Array(repeating: false, count: N), count: M)
    var box = [(Int,Int,Int)]()
    var count = 0
    var empty = 0
    var check = 0
    for i in 0..<M{
        input = readLine()!.split(separator: " ").map{ Int($0)! }
        a[i] = input
        for j in 0..<N{
            if a[i][j] == 0{
                empty += 1
            }
            if a[i][j] == 1 && !v[i][j]{
                box.append((i,j,0))
            }
        }
    }

    bfs()

    empty == 0 ? print(0) : (empty == check ? print(count) : print(-1))
    func bfs() {
        while !box.isEmpty{
            let now = box.removeFirst()
            let nx = now.0
            let ny = now.1
            let nc = now.2
            v[nx][ny] = true
            for i in 0..<4{
                let xx: Int = nx + dx[i]
                let yy: Int = ny + dy[i]
                if xx >= 0 && yy >= 0 && xx < M && yy < N && !v[xx][yy] && a[xx][yy] == 0{
                    box.append((xx,yy,nc+1))
                    a[xx][yy] = 1
                    v[xx][yy] = true
                    check += 1
                }
            }
            count = Swift.max(nc, count)
        }
    }
}
