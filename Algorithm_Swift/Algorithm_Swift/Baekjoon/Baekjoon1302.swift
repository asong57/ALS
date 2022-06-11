//
//  Baekjoon1302.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/06/11.
//

import Foundation

func BJ1302(){
    let N = Int(readLine()!)!
    var check: [String: Int] = [:]
    var top = 0
    for i in 0..<N{
        let word = readLine()!
        check[word, default: 0] += 1
        if top < check[word]!{
            top = check[word]!
        }
    }
    var list: [String] = []
    for (k,v) in check{
        if v == top{
            list.append(k)
        }
    }
    list.sort()
    print(list[0])
}
