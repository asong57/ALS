//
//  Programmers_JadenCase.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/06/27.
//

import Foundation

func solution_JadenCase(_ s:String) -> String {
    let strs = s.split(separator: " ").map{ String($0)}
    var jaden = ""
    var i = 0
    for w in s{
        if w == " "{
            jaden += " "
            i = 0
            continue
        }
        if i == 0{
            jaden += String(w).uppercased()
        }else{
            jaden += String(w).lowercased()
        }
        i += 1
    }
        
    return jaden
}
