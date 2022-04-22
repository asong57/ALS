//
//  Programmers_TableEdit.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/22.
//

import Foundation

func solution_TableEdit(_ n:Int, _ k:Int, _ cmd:[String]) -> String {
    var temp = k
    var size = n
    var stack: [Int] = []
    var answer: [String] = Array(repeating:"O", count: n)
    for s in cmd{
        let cmds = s.split(separator: " ").map{String($0)}
        if cmds[0] == "U"{
            temp -= Int(cmds[1])!
        }else if cmds[0] == "D"{
            temp += Int(cmds[1])!
        }else if cmds[0] == "C"{
            stack.append(temp)
            size -= 1
            if temp == size{
                temp -= 1
            }
        }else{
            let restore = stack.removeLast()
            if temp >= restore{
                temp += 1
            }
            size += 1
        }
    }
    
    var str = ""
    for i in 0..<size{
        str += "O"
    }
    var i = stack.count - 1
    while i >= 0{
        let index = str.index(str.startIndex, offsetBy: stack[i])
        str.insert("X", at: index)
        i -= 1
    }
    return str
}
