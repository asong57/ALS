//
//  Programmers_OpenChattingRoom.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/22.
//

import Foundation

func solutionOpenChattingRoom(_ record:[String]) -> [String] {
    var dict: [String:String] = [:]
    for str in record{
        let s = str.split(separator: " ").map{ String($0)}
        if s[0] == "Enter"{
            dict[s[1]] = s[2]
        }else if s[0] == "Change"{
             dict[s[1]] = s[2]
        }
    }
    var answer: [String] = []
    for str in record{
        let s = str.split(separator: " ").map{ String($0)}
        if s[0] == "Enter"{
            answer.append("\(dict[s[1]]!)님이 들어왔습니다.")
        }else if s[0] == "Leave"{
            answer.append("\(dict[s[1]]!)님이 나갔습니다.")
        }
    }
    return answer
}
