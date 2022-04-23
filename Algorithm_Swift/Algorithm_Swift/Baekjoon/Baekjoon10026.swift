//
//  Baekjoon10026.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/23.
//

import Foundation

func BJ10026(){
    let n = Int(readLine()!)!
    var blocks: [[String]] = []
    for _ in 0..<n{
        let input = readLine()!.map{String($0)}
        blocks.append(input)
    }
    var a = 0
    var b = 0
    var check: [[Bool]] = Array(repeating: Array(repeating: false, count: n), count: n)
    let dx = [0,1,0,-1]
    let dy = [1,0,-1,0]
    for i in 0..<n{
        for j in 0..<n{
            if !check[i][j]{
                abfs(i,j)
                a += 1
            }
        }
    }
    check = Array(repeating: Array(repeating: false, count: n), count: n)
    for k in 0..<n{
        for h in 0..<n{
            if !check[k][h]{
                bbfs(k,h)
                b += 1
            }
        }
    }
    print(a,b)
    
    func abfs(_ x: Int, _ y: Int){
        check[x][y] = true
        var q: [(Int, Int)] = [(Int, Int)]()
        q.append((x,y))
        while !q.isEmpty{
            let now = q.removeFirst()
            let color = blocks[now.0][now.1]
            
            for i in 0..<4{
                let xx = now.0 + dx[i]
                let yy = now.1 + dy[i]
                if xx >= 0 && yy >= 0 && xx < n && yy < n && !check[xx][yy]{
                    if color == blocks[xx][yy]{
                        q.append((xx,yy))
                        check[xx][yy] = true
                    }
                }
            }
        }
    }
    func bbfs(_ x: Int, _ y: Int){
        check[x][y] = true
        var q: [(Int, Int)] = [(Int, Int)]()
        q.append((x,y))
        while !q.isEmpty{
            let now = q.removeFirst()
            let color = blocks[now.0][now.1]
            
            for i in 0..<4{
                let xx = now.0 + dx[i]
                let yy = now.1 + dy[i]
                if xx >= 0 && yy >= 0 && xx < n && yy < n && !check[xx][yy]{
                    
                    if color == blocks[xx][yy]{
                        q.append((xx,yy))
                        check[xx][yy] = true
                    }else{
                        if color == "R" && blocks[xx][yy] == "G"{
                            q.append((xx,yy))
                            check[xx][yy] = true
                        }else if color == "G" && blocks[xx][yy] == "R"{
                            q.append((xx,yy))
                            check[xx][yy] = true
                        }
                    }
                }
            }
        }
    }

}
