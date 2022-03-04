//
//  Baekjoon1181.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/04.
//

import Foundation

BJ1181(){
    // 내 풀이
    let n = Int(readLine()!)!
    var dict: [Int: [String]] = [:]
    for _ in 0..<n{
        let str = String(readLine()!)
        if dict[str.count] == nil {
            var arr: [String] = []
            arr.append(str)
            dict[str.count] = arr
        }else{
            var arr = dict[str.count]
            arr?.append(str)
            dict[str.count] = arr
            
        }
    }
    var set: Set<String> = Set<String>()
    l: for i in 1...50{
        if dict[i] == nil{
            continue l
        }else{
            var arr = dict[i]!
            arr.sort()
            for s in arr {
                if !set.contains(s){
                    set.insert(s)
                    print(s)
                }
            }
        }
    }

    // 참고한 풀이
    let num: Int = Int(readLine()!)!
    var arr: [String] = []
    for _ in 1...num {
        arr.append(readLine()!)
    }

    arr = Array(Set(arr)).sorted(by: { $0 < $1 }).sorted(by: { $0.count < $1.count })

    for str in arr{
      print(str)
    }
}
