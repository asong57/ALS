//
//  Programmers_ReportResults.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/02/17.
//

import Foundation

func solution_ReportResults(_ id_list:[String], _ report:[String], _ k:Int) -> [Int] {
    var dict: [String: Set<String>] = [:]
    for reportStr in report {
        let strs = reportStr.split(separator: " ").map{ String($0)}
        if dict[strs[1]] == nil{
            dict[strs[1]] = Set<String>()
            dict[strs[1]]?.insert(strs[0])
        }else{
            dict[strs[1]]?.insert(strs[0])
        }
    }
    var countDict: [String: Int] = [:]
    for (key, value) in dict {
        if value.count >= k {
            for s in value {
                if countDict[s] == nil {
                    countDict[s] = 1
                }else{
                    countDict[s]! += 1
                }
            }
            
        }
    }
    var answer: [Int] = []
    for id in id_list {
        if countDict[id] != nil {
            answer.append(countDict[id]!)
        }else{
            answer.append(0)
        }
    }
    return answer
}

