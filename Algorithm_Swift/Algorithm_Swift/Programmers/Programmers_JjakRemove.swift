//
//  Programmers_JjakRemove.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/12.
//

import Foundation

func solution_JjakRemove(_ s:String) -> Int{
    var answer:Int = -1
    
    if s.count % 2 != 0{
        return 0
    }
    var temp: [Character] = []
    for c in s{
        if temp.last == c{
            temp.removeLast()
        }else{
            temp.append(c)
        }
    }
    if temp.count > 0{
        return 0
    }else{
        return 1
    }
}
