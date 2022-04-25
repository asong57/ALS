//
//  Programmers_DistanceCheck.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/02/18.
//

import Foundation

func solution(_ places:[[String]]) -> [Int] {
    var arr: [[Character]] = Array(repeating: Array(repeating: "j", count: 5), count: 5)
    var answer: [Int] = []
    for a in 0..<places.count {
        for i in 0..<places[a].count{
            for (j, value) in places[a][i].enumerated(){
                arr[i][j] = value
            }
        }
        answer.append(checkDistance(arr: arr))
    }
    // 2차원 문자열배열 쉽게 String 이차원 접근 배열로 변환하는 법
    /*
    let places = places.map {$0.map{$0.map{String($0)}}}
    for place in places {
        res.append(isManhattanDistance(place) ? 1:0)
    }*/
    return answer
}

func checkDistance(arr: [[Character]])-> Int {
    let dx = [1,0,-1,0]
    let dy = [0,1,0,-1]
    
    for i in 0..<arr.count{
        for j in 0..<arr[i].count{
            if arr[i][j] == "P"{
            l: for k in 0..<4{
                    var xx = i + dx[k]
                    var yy = j + dy[k]
                    if xx >= 0 && yy >= 0 && xx < 5 && yy < 5 {
                        if arr[xx][yy] == "X" {
                            continue l
                        }
                        if arr[xx][yy] == "P" {
                            return 0
                        }
                        
                    p: for h in 0..<4{
                            if h != k && h%2 == k%2 {
                                continue p
                            }
                            var hx = xx + dx[h]
                            var hy = yy + dy[h]
                            if hx >= 0 && hy >= 0 && hx < 5 && hy < 5 {
                                if (arr[hx][hy] == "X") {
                                    continue p
                                    
                                }
                                if arr[hx][hy] == "P" {
                                    return 0
                                }
                                
                            }
                        }
                    }
                }
            }
        }
    }
    
    return 1
}

func solution_DistanceCheck2(_ places:[[String]]) -> [Int] {
    var arr: [[Character]] = []
    var answer: [Int] = []
    for i in 0..<places.count{
        arr = Array(repeating: [], count: 5)
        for j in 0..<places[i].count{
            for c in places[i][j]{
                arr[j].append(c)
            }
        }
       answer.append(checkPlace(arr))
    }
    return answer
}
func checkPlace(_ arr: [[Character]]) -> Int{
    let dx = [0,1,0,-1]
    let dy = [1,0,-1,0]
    var visit = Array(repeating: Array(repeating: false, count: 5), count: 5)
    for i in 0..<5{
        for j in 0..<5{
            if arr[i][j] == "P"{
                visit[i][j] = true
                l: for k in 0..<4{
                    let xx = i + dx[k]
                    let yy = j + dy[k]
                    if xx >= 0 && yy >= 0 && xx < 5 && yy < 5 && !visit[xx][yy]{
                        if arr[xx][yy] == "X"{
                            continue l
                        }
                        if arr[xx][yy] == "P"{
                            return 0
                        }
                        n: for h in 0..<4{
                            if h != k && h % 2 == k % 2{
                                    continue n
                            }
                            let xh = xx + dx[h]
                            let yh = yy + dy[h]
                            if xh >= 0 && yh >= 0 && xh < 5 && yh < 5 && !visit[xh][yh]{
                                if arr[xh][yh] == "P"{
                                    return 0
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    return 1
}
