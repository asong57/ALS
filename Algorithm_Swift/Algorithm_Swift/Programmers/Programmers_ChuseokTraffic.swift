//
//  Programmers_ChuseokTraffic.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/27.
//

import Foundation

func solution_Traffic(_ lines:[String]) -> Int {
    var arr: [Traffic] = []
    for line in lines{
        arr.append(calculateTime(line))
    }
    arr = arr.sorted(by: {$0.start < $1.start})
    var time = arr[0].start
    var left = 0
    var answer = 0
    while time <= arr[arr.count-1].end && left < arr.count{
        time = arr[left].start
        while arr[left].end > time{
            var i = left + 1
            var count = 1
            while i < arr.count && arr[i].start < time + 1000{
                count += 1
                i += 1
            }
            i = left - 1
            while i >= 0 && arr[i].end >= time{
                count += 1
                i -= 1
            }
            if count > answer{
                 answer = count
            }
            time += 1000
        }
        
        time = arr[left].end
        var i = left + 1
        var count = 1
        while i < arr.count && arr[i].start >= time && arr[i].start < time + 1000{
                count += 1
                i += 1
        }
        var j = left - 1
        time -= 1000
        while j >= 0 && arr[j].end < time {
            i = left - 1
            while i >= 0 && arr[i].end >= time{
                count += 1
                i -= 1
            }
            time -= 1000
        }
        if count > answer{
            answer = count
        }
        left += 1
    }
    return answer
}
func calculateTime(_ line: String) -> Traffic{
    let times = line.split(separator: " ").map{String($0)}
    let sTimes = times[1].split(separator: ":").map{String($0)}
    let ss = sTimes[2].split(separator: ".").map{Int($0)!}
    var endTime = ss[0] * 1000 + ss[1] + Int(sTimes[1])! * 60 * 1000 + Int(sTimes[0])! * 60 * 60 * 1000
    var duration = 0
    if times[2].contains("."){
        let durations = times[2].split(separator: ".").map{String($0)}
        let s = durations[1].split(separator: "s").map{String($0)}
        duration = Int(durations[0])! * 1000 + Int(s[0])!
        
    }else{
        let s = times[2].split(separator: "s").map{Int($0)!}
        duration = s[0] * 1000
    }
    var startTime = endTime - duration + 1
    return Traffic(startTime, endTime)
}
class Traffic{
    let start: Int
    let end: Int
    init(_ start: Int, _ end: Int){
        self.start = start
        self.end = end
    }
}
