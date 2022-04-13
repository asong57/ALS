//
//  Programmers_SheepWolf.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/13.
//

import Foundation

var childs: [[Int]] = []
var infoList: [Int] = []
var max = 0

func solution_SheepWolf(_ info:[Int], _ edges:[[Int]]) -> Int {
    infoList = info
    childs = Array(repeating: [], count: info.count)
    var visit = Array(repeating: false, count: info.count)
    for i in 0..<edges.count{
        let parent = edges[i][0]
        let child = edges[i][1]
        childs[parent].append(child)
    }
    var list = [0]
    dfs(0,0,0,list, visit)
    return max
}
func dfs(_ idx: Int, _ sheepCnt: Int, _ wolfCnt: Int, _ nextPos: [Int], _ visited: [Bool]){
    var sheep = sheepCnt
    var wolf = wolfCnt
    var visit = visited
    if infoList[idx] == 0{
        sheep += 1
    }else{
        wolf += 1
    }
    
    if wolf >= sheep {
        return
    }
    max = Swift.max(sheep, max)
    
    var list: [Int] = []
    visit[idx] = true
    list.append(contentsOf: nextPos)
    if childs[idx] != nil {
        for i in 0..<childs[idx].count{
            list.append(childs[idx][i])
        }
    }
    h: for l in list{
        if l == idx{
            continue h
        }
        if visit[l] == false{
            dfs(l, sheep, wolf, list, visit)
        }
    }
}
