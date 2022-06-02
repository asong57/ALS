//
//  Programmers_StrangeLetter.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/06/02.
//

import Foundation

func solution_StrangeLetter(_ s:String) -> String {
    var str = ""
    var i = 0
    for j in 0..<s.count{
        let c =  String(s[s.index(s.startIndex, offsetBy: j)])
        if c == " "{
            str += " "
            i = 0
            continue
        }
        if i % 2 != 0{
            str += c.lowercased()
        }else{
            str += c.uppercased()
        }
        i += 1
    }
    return str
}
