//
//  Baekjoon6550.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/23.
//

import Foundation

func BJ6550(){
    var line: String?
    l: while true{
        if let a = readLine(){
           line = a
        }else{
            break l
        }
        let l = line!.split(separator: " ").map{ String($0)}
        let s = l[0].lowercased()
        let t = l[1].lowercased()
        if s == t{
            print("No")
            continue l
        }
        var j = 0
        for i in 0..<t.count{
            if s[s.index(s.startIndex, offsetBy: j)] == t[t.index(t.startIndex, offsetBy: i)]{
                if j < s.count-1{
                    j += 1
                }else if j == s.count - 1{
                    print("Yes")
                    continue l
                }
            }
        }
        if j == s.count-1 {
            print("Yes")
        }else{
            print("No")
        }
    }
}
