//
//  Programmers_ShuttleBus.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/20.
//

import Foundation

func solution_ShuttleBus(_ n:Int, _ t:Int, _ m:Int, _ timetable:[String]) -> String {
    var arr: [Int] = []
    for i in 0..<timetable.count{
        let time = timetable[i].split(separator: ":").map{Int($0)!}
        arr.append(time[0]*60+time[1])
    }
    arr.sort()
    var bus: [Int] = Array(repeating: 0, count: n)
    var depart = 60 * 9
    var answer = 0
    for i in 0..<n{
        while arr.count > 0{
            let crew = arr.removeFirst()
            if crew <= depart && bus[i] < m{
             bus[i] += 1
             answer = crew - 1
            }else{
                arr.insert(crew, at: 0)
                break
            }
        }
        depart += t
    }
    if bus[n-1] < m{
        answer = depart - t
    }
    var str = ""
    if answer / 60 < 10{
        str = "0" + String(answer / 60 )
    }else{
        str = String(answer / 60 )
    }
    str += ":"
    if answer % 60 < 10{
        str += "0" + String(answer % 60)
    }else{
        str += String(answer % 60)
    }
    return str
}
