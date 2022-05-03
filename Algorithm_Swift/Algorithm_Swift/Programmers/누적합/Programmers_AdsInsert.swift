//
//  Programmers_AdsInsert.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/05/03.
//

import Foundation

func solution(_ play_time:String, _ adv_time:String, _ logs:[String]) -> String {
    var times = play_time.split(separator:":").map{Int($0)!}
    let finishTime = times[0]*3600+times[1]*60+times[2]
    times = adv_time.split(separator:":").map{Int($0)!}
    let advTime = times[0]*3600+times[1]*60+times[2]
    var arr: [Int64] = Array(repeating: 0, count: finishTime+1)
    for log in logs{
        let times = log.split(separator: "-").map{String($0)}
        let starts = times[0].split(separator: ":").map{Int($0)!}
        let start = starts[0]*3600 + starts[1]*60 + starts[2]
        let ends = times[1].split(separator: ":").map{Int($0)!}
        let end = ends[0]*3600 + ends[1]*60 + ends[2]
        arr[start] += 1
        arr[end] -= 1
    }
    for i in 1..<arr.count{
        arr[i] += arr[i-1]
    }
    for i in 1..<arr.count{
        arr[i] += arr[i-1]
    }
    var answer = 0
    var startTime = 0
    var endTime = advTime
    var maxTime: Int64 = arr[endTime-1]
    var i = endTime
    while i <= finishTime{
        if arr[i] - arr[i-advTime] > maxTime{
            maxTime = arr[i] - arr[i-advTime]
            answer = i-advTime+1
        }
        i += 1
    }
    var str = ""
    if answer == 0 {
        return "00:00:00"
    }
    var s = answer % 60
    if s < 10{
        str = "0"+String(s)
    }else{
        str = String(s)
    }
    var m = (answer / 60) % 60
    if m < 10{
        str = "0" + String(m) + ":" + str
    }else{
        str = String(m) + ":" + str
    }
    var h = (answer / 3600) % 60
    if h < 10{
        str = "0" + String(h) + ":" + str
    }else{
        str = String(h) + ":" + str
    }
    
    return str
}
