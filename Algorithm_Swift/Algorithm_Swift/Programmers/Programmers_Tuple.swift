//
//  Programmers_Tuple.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/03.
//

import Foundation

func tuple(s: String) -> [Int] {
    var p = s[s.index(s.startIndex, offsetBy: 1)...s.index(s.endIndex, offsetBy: -2)]
    let strs = p.split(separator: "{")
    var dict: [Int: [String]] = [:]
    var set: Set<Int> = []
    for str in strs {
        let ss = str.split(separator: "}")
        let numbers: [String] = ss[0].split(separator: ",").map{
            String($0)
        }
        dict[numbers.count] = numbers
    }
    var answer: [Int] = []
    for i in 1...dict.count{
        
        for k in dict[i]!{
            let num = Int(k)
            if(!set.contains(num!)){
                set.insert(num!)
                answer.append(num!)
            }
        }
    }
    
    return answer
}
