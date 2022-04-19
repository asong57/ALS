//
//  Programmers_NBinaryGame.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/19.
//

import Foundation

func solution(_ n:Int, _ t:Int, _ m:Int, _ p:Int) -> String {
   // let str = changeNumber(n, m*t).map{ String($0) }
    var num = 0
    var q = [Character]()
    while q.count <= t*m {
        let ns = String(num, radix: n)
        ns.forEach {
            q.append($0)
        }
        num += 1
    }
    var current = p-1
    var sender = ""
    while sender.count < t{
        sender.append(String(q[current]).uppercased())
        current += m
    }

    return sender
}
func changeNumber(_ n: Int,_ size: Int) -> String{
    var str = "0"
    var num = 1
    while str.count <= size{
        var i = num
        var s = ""
        while i > 0 {
            let a = i % n
            if a > 9{
                switch a {
                    case 10: s = "A" + s
                    case 11: s = "B" + s
                    case 12: s = "C" + s
                    case 13: s = "D" + s
                    case 14: s = "E" + s
                    case 15: s = "F" + s
                    default: s = " "+s
                }
            }else{
                s  = String(i%n)  + s
            }
            i /= n
        }
        str = str + s
        num += 1
    }
    return str
}
