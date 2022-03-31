//
//  Programmers_BiggestNumber.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/31.
//

import Foundation

func solution_BiggestNumber(_ numbers:[Int]) -> String {
    var num = numbers.map{ String($0)}
    var str = ""
    num.sort(by: {$0+$1 > $1+$0})
    if num[0] == "0"{
        return "0"
    }else{
        for n in num{
            str += n
        }
    }
    return str
}
