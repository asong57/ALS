//
//  Baekjoon3029.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/11.
//

import Foundation

func BJ3029(){
    var now = readLine()!.split(separator: ":").map{ Int($0)! }
    var time = readLine()!.split(separator: ":").map{ Int($0)! }

    if now[0] > time[0]{
        time[0] += 24
    }
    var s = time[2] - now[2]
    var min = time[1] - now[1]
    var h = time[0] - now[0]
    if s < 0{
        s += 60
        min -= 1
    }
    if min < 0{
        min += 60
        h -= 1
    }
    var str = ""
    if s < 10{
        str  = "0"+String(s) + str
    }else{
        str = String(s) + str
    }
    str = ":" + str
    if min < 10{
        str = "0"+String(min) + str
    }else{
        str = String(min) + str
    }
    str = ":" + str
    if h < 10{
        str  = "0"+String(h) + str
    }else{
        str = String(h) + str
    }
    if str == "00:00:00"{
        print("24:00:00")
    }else{
        print(str)
    }
}
