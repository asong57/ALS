//
//  Baekjoon11478.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/09/19.
//

import Foundation

func BJ11478(){
    let s = readLine()!.map{String($0)}

    var stringSet: Set<String> = Set<String>()
    let size = s.count
    for i in 0..<size {
        var word = ""
        for j in i..<size {
            word += s[j]
            stringSet.insert(word)
        }
    }
    print(stringSet.count)
}
