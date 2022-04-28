//
//  Programmers_IllegalUser.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/28.
//

import Foundation

var answer: Int = 0
var set: Set<Set<String>> = Set<Set<String>>()
func solution(_ user_id:[String], _ banned_id:[String]) -> Int {
    var arr: [[String]] = Array(repeating: [], count: banned_id.count)
    for i in 0..<banned_id.count{
        arr[i].append(contentsOf: makeBannedIdArr(banned_id[i], user_id))
    }
    dfs(Set<String>(), 0, arr)
    return answer
}
func dfs(_ check: Set<String>, _ depth: Int, _ arr: [[String]]){
    var check = check
    if depth == arr.count{
        if !set.contains(check){
            answer += 1
            set.insert(check)
        }
    }else{
        for i in 0..<arr[depth].count{
            if !check.contains(arr[depth][i]){
                check.insert(arr[depth][i])
                dfs(check, depth+1, arr)
                check.remove(arr[depth][i])
            }
        }
    }
}
func makeBannedIdArr(_ bannedId: String, _ userId: [String]) -> [String]{
    var arr: [String] = []
    l: for i in 0..<userId.count{
        if userId[i].count != bannedId.count{
            continue
        }
        var j = 0
        var user = userId[i]
        m: for b in bannedId{
            if b == "*"{
                j += 1
                continue m
            }
            if b != user[user.index(user.startIndex, offsetBy: j)]{
                continue l
            }
            j += 1
        }
        arr.append(user)
    }
    return arr
}
