//
//  Programmers_Compaction.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/20.
//

import Foundation

func solution_Compaction(_ msg:String) -> [Int] {
    var dict: [String: Int] = [:]
    for i in 0...25 {
        dict[String(Character(UnicodeScalar(65+i)!))] = i+1
    }
    var i = 0
    var answer: [Int] = []
    var count = 27
    while i < msg.count{
        let w = String(msg[msg.index(msg.startIndex, offsetBy: i)])
        var num = dict[w]!
        var next = 1
        if i + next >= msg.count{
            answer.append(num)
            break
        }
        var wc = String(msg[msg.index(msg.startIndex, offsetBy: i)...msg.index(msg.startIndex, offsetBy: i+next)])
        if dict[wc] == nil{
            dict[wc] = count
            count += 1
            answer.append(num)
        }else{
            while dict[wc] != nil{
                num = dict[wc]!
                next += 1
                if i+next > msg.count-1{
                    break
                }
                wc = String(msg[msg.index(msg.startIndex, offsetBy: i)...msg.index(msg.startIndex, offsetBy: i+next)])
            }
            dict[wc] = count
            count += 1
            answer.append(num)
        }
        i += next
    }
    return answer
}
