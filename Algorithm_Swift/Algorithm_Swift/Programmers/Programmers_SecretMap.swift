//
//  Programmers_SecretMap.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/08.
//

import Foundation

func solution_SecretMap(_ n:Int, _ arr1:[Int], _ arr2:[Int]) -> [String] {
    var answer: [String] = []
    var arr: [String] = []
    for i in 0..<arr1.count{
        var a = changeBinaryNumber(arr1[i])
        var b = changeBinaryNumber(arr2[i])
        var str = ""
        while a.count < n{
            a = "0" + a
        }
        while b.count < n{
            b = "0" + b
        }

        for j in 0..<n{
            if String(a[a.index(a.startIndex, offsetBy: j)]) == "1" || String(b[b.index(b.startIndex, offsetBy: j)]) == "1"{
                str += "#"
            }else{
                str += " "
            }
        }
        arr.append(str)
    }
    return arr
}
func changeBinaryNumber(_ num: Int) -> String{
    var n = num
    var str = ""
    while n != 0{
        str  = String(n % 2) + str
        n /= 2
    }
    return str
}
