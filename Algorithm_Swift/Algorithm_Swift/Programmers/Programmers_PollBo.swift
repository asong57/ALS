//
//  Programmers_PollBo.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/05/05.
//

import Foundation

var bo: [[Bool]] = []
var poll: [[Bool]] = []
func solution(_ n:Int, _ build_frame:[[Int]]) -> [[Int]] {
    var arr: [[Int]] = Array(repeating: Array(repeating: -1, count: n+1), count: n+1)
    bo = Array(repeating: Array(repeating: false, count: n+1), count: n+1)
    poll = Array(repeating: Array(repeating: false, count: n+1), count: n+1)
    for i in 0..<build_frame.count{
        let x = build_frame[i][0]
        let y = build_frame[i][1]
        if build_frame[i][3] == 1{
            if build_frame[i][2] == 0{
                 if checkPoll(arr,x,y){
                     poll[x][y] = true
                 }
            }else{
                if checkBo(arr,x,y){
                    bo[x][y] = true
                }
            }
        }else{
            if build_frame[i][2] == 0{
                poll[x][y] = false
                 if !checkDelete(arr){
                    poll[x][y] = true
                }
            }else{
                 bo[x][y] = false
                 if !checkDelete(arr){
                    bo[x][y] = true
                }
            }
        }
    }
    var result: [[Int]] = []
    for i in 0..<arr.count{
        for j in 0..<arr.count{
            if poll[i][j] == true{
                let a = [i,j,0]
                result.append(a)
            }
            if bo[i][j] == true{
                let a = [i,j,1]
                result.append(a)
            }
        }
    }
    return result
}
func checkPoll(_ arr: [[Int]], _ x: Int, _ y: Int) -> Bool{
    if y == 0 {
        return true
    }
    if x > 0 && bo[x-1][y] || bo[x][y]{
        return true
    }
    if y > 0 && poll[x][y-1]  {
        return true
    }
    return false
}
func checkBo(_ arr: [[Int]], _ x: Int, _ y: Int) -> Bool{
    if y > 0 && poll[x][y-1]{
        return true
    }else if y > 0 && poll[x+1][y-1]{
        return true
    }else if x > 0 && bo[x-1][y] && bo[x+1][y] {
        return true
    }
    return false
}
func checkDelete(_ arr: [[Int]]) -> Bool{
    for i in 0..<arr.count{
        for j in 0..<arr.count{
            if poll[i][j] && checkPoll(arr,i,j) == false{
                return false
            }
            if bo[i][j] && checkBo(arr,i,j) == false{
                return false
            }
        }
    }
    return true
}
