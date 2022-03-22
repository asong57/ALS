//
//  Baekjoon9934.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/22.
//

import Foundation

func BJ9934(){
    let k = Int(readLine()!)!

    let a = readLine()!.split(separator: " ").map{Int($0)!}
    var ans: [[Int]] = Array(repeating: [], count: k)
    tree(0, a.count-1, 0)
    for i in 0..<ans.count{
        var str = ""
        for j in 0..<ans[i].count{
            str += String(ans[i][j])+" "
        }
        print(str)
    }

    func tree(_ start: Int, _ end: Int, _ depth: Int){
        if start > end{
            return
        }
        let mid = (start + end) / 2
        
        ans[depth].append(a[mid])
        tree(start, mid-1, depth+1)
        tree(mid+1, end, depth+1)
    }
}
