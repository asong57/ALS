//
//  Programmers_StringSort.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/02.
//

import Foundation

func solution(_ strings:[String], _ n:Int) -> [String] {
    var answer: [String] = []
    var indexList: [String] = []
    var dict: [String: Array<String>] = [:]
    for i in 0..<strings.count {
        let str = strings[i]
        let s = String(str[str.index(str.startIndex, offsetBy: n)])
        if !indexList.contains(s) {
            indexList.append(s)
            dict[s] = Array<String>()
        }
        var arr: [String] = dict[s]!
        arr.append(strings[i])
        dict[s] = arr
    }
    
    indexList.sort()
    for c in indexList {
        var newList: [String] = dict[c]!
        newList.sort()
        for str in newList {
            answer.append(str)
        }
    }
    return answer
}
