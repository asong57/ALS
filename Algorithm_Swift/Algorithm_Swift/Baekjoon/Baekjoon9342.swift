//
//  Baekjoon9342.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/17.
//

import Foundation

func BJ9342(){
    let n = Int(readLine()!)!
    l: for _ in 0..<n{
        let str = readLine()!
        var aCheck = false
        var check = false
        var cCheck = false
        if str[str.index(str.startIndex, offsetBy: 0)] == "A" {
            aCheck = true
        }
    r: for i in 1..<str.count{
        let s = str[str.index(str.startIndex, offsetBy: i)]
        
        if !aCheck && s != "A"{
            print("Good")
            continue l
        }
        
        if s == "A" && !check{
            aCheck = true
            continue r
        }
        if aCheck && check && s != "F" {
            if s == "C"{
                cCheck = true
                continue r
            }else{
                print("Good")
                continue l
            }
        }
        if aCheck && !cCheck {
            if s == "F"{
                check = true
                continue r
            }else  {
                print("Good")
                continue l
            }
        }
        
        if cCheck && s != "C"{
            if (s != "A" || s != "B" || s != "C" || s != "D" || s != "E" || s != "F") {
                print("Good")
                continue l
            }else if i != str.count-1{
                print("Good")
                continue l
            }
        }
    }
        print("Infected!")
    }
}
