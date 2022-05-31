//
//  Programmers_DoubleQueue.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/05/31.
//

import Foundation

func solution_DoubleQ(_ operations:[String]) -> [Int] {
    var q: [Int] = []
    for str in operations{
        let strs = str.split(separator: " ").map{String($0)}
        if strs[0] == "I"{
            q.append(Int(strs[1])!)
        }else{
            let n = Int(strs[1])!
            if q.count == 0{
                continue
            }
            q.sort()
            if n < 0{
                q.removeFirst()
            }else{
                q.removeLast()
            }
        }
    }
    if q.count == 0{
        return [0,0]
    }
    q.sort()
    return [q.last!,q[0]]
}
