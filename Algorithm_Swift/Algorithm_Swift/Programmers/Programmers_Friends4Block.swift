//
//  Programmers_Friends4Block.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/05/05.
//

import Foundation

func solution_FriendsBlock(_ m:Int, _ n:Int, _ board:[String]) -> Int {
    var arr: [[Character]] = Array(repeating: Array(repeating: " ", count: n), count: m)
    for i in 0..<m{
        var j = 0
        for c in board[i]{
            arr[i][j] = c
            j += 1
        }
    }
    
    var visit: [[Bool]] = Array(repeating: Array(repeating: false, count: n), count: m)
    var count = 0
    var isUpdate = true
    while isUpdate{
        isUpdate = false
        visit = Array(repeating: Array(repeating: false, count: n), count: m)
        for i in 0..<m-1{
            for j in 0..<n-1{
                if arr[i][j] == " "{
                    continue
                }
                if arr[i][j] == arr[i+1][j] && arr[i][j] == arr[i][j+1] && arr[i][j] == arr[i+1][j+1]{
                    isUpdate = true
                    if !visit[i][j]{
                        visit[i][j] = true
                        count += 1
                    }
                    if !visit[i+1][j]{
                        visit[i+1][j] = true
                        count += 1
                    }
                    if !visit[i][j+1]{
                        visit[i][j+1] = true
                        count += 1
                    }
                    if !visit[i+1][j+1]{
                        visit[i+1][j+1] = true
                        count += 1
                    }
                }
            }
        }
        var list: [Character] = []
        for j in 0..<n{
            for i in 0..<m{
                if !visit[i][j]{
                    list.append(arr[i][j])
                }
            }
            var k = m-1
            while k >= 0{
                if list.count <= 0{
                    arr[k][j] = " "
                }else{
                    arr[k][j] = list.removeLast()
                }
                k -= 1
            }
        }
    }

    return count
}
