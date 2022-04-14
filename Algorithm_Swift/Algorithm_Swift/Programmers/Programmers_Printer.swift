//
//  Programmers_Printer.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/14.
//

import Foundation

func solution_Printer(_ priorities:[Int], _ location:Int) -> Int {
    var prior = priorities
    prior.sort(by: >)
    var list: [Int] = []
    for i in 0..<priorities.count{
        list.append(i)
    }
    var count = 0
    while list.count > 0{
        if priorities[list[0]] == prior[0]{
            count += 1
            if list[0] == location{
                return count
            }
            list.removeFirst()
            prior.removeFirst()
        }else{
            list.append(list.removeFirst())
        }
    }
    return 0
}
