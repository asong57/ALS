//
//  Baekjoon2941.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/06/09.
//

import Foundation

func BJ2941(){
    var input = String(readLine()!)
    var size = input.count
    var b = 0
    if input.contains("c="){
        input = input.replacingOccurrences(of: "c=", with: "a")
    }
    if input.contains("c-"){
        input = input.replacingOccurrences(of: "c-", with: "a")
    }
    if input.contains("dz="){
        input = input.replacingOccurrences(of: "dz=", with: "a")
    }
    if input.contains("d-"){
        input = input.replacingOccurrences(of: "d-", with: "a")
    }
    if input.contains("nj"){
        input =  input.replacingOccurrences(of: "nj", with: "a")
    }
    if input.contains("š"){
        input = input.replacingOccurrences(of: "š", with: "a")
    }
    if input.contains("dž"){
        input =  input.replacingOccurrences(of: "dž", with: "a")
    }else if input.contains("ž"){
        input = input.replacingOccurrences(of: "ž", with: "a")
    }
    if input.contains("lj"){
        input = input.replacingOccurrences(of: "lj", with: "a")
    }
    for s in input{
        if s != "-" && s != "="{
            b += 1
        }
    }
    print(b)

}
