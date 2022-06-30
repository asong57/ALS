//
//  Baekjoon3190.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/06/30.
//

import Foundation

func BJ3190(){
    let N = Int(readLine()!)!
    let K = Int(readLine()!)!
    var board = Array(repeating: Array(repeating: 0, count: N), count: N)
    for i in 0..<K{
        let apples = readLine()!.split(separator: " ").map{Int($0)!}
        board[apples[0]-1][apples[1]-1] = 2
    }
    let L = Int(readLine()!)!
    var times: [Int] = []
    var directions: [String] = []
    for i in 0..<L{
        let direction = readLine()!.split(separator: " ").map{String($0)}
        times.append(Int(direction[0])!)
        directions.append(direction[1])
    }
    var time = 0
    let dx = [-1,0,1,0]
    let dy = [0,1,0,-1]
    var i = 1
    var nx = 0
    var ny = 0
    board[0][0] = 1
    var tx = 0
    var ty = 0
    var snake: [(Int,Int)] = [(0,0)]
    while true{
        if times.count > 0 && times[0] == time{
            if directions[0] == "L"{
                i -= 1
                if i < 0{
                    i = 3
                }
            }else{
                i += 1
                if i >= 4{
                    i = 0
                }
            }
            times.removeFirst()
            directions.removeFirst()
        }
        nx = nx + dx[i]
        ny = ny + dy[i]
        if nx < 0 || ny < 0 || nx == N || ny == N{
            print(time+1)
            break
        }
        if board[nx][ny] == 1{
            print(time+1)
            break
        }
        snake.append((nx,ny))
        
        if board[nx][ny] == 0{
            let tail = snake.removeFirst()
            let lx = tail.0
            let ly = tail.1
            board[lx][ly] = 0
        }
        board[nx][ny] = 1
        time += 1
    }
}
