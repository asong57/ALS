//
//  Programmers_HanoiTower.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/06/22.
//

import Foundation

var answer:[[Int]] = []
func solution_HanoiTower(_ n:Int) -> [[Int]] {
    move(n, 1,2,3)
    return answer
}
func move(_ n:Int, _ from:Int, _ by: Int, _ to: Int){
    if n == 1{
        answer.append([from,to])
    }else{
        move(n-1, from, to, by)
        answer.append([from, to])
        move(n-1, by, from, to)
    }
}
