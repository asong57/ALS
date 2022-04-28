//
//  Programmers_RightTheSong.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/28.
//

import Foundation

func solution_RightTheSong(_ m:String, _ musicinfos:[String]) -> String {
    var t = setString(m)
    var arr: [Music] = []
    for i in 0..<musicinfos.count{
        let music = setString(musicinfos[i])
        let strs = music.split(separator: ",").map{String($0)}
        let start = strs[0].split(separator:":").map{Int($0)!}
        let end = strs[1].split(separator:":").map{Int($0)!}
        let time = end[0]*60 + end[1] - start[0]*60 - start[1]
        var str = strs[3]
        var s = ""
        for i in 0..<time{
            var index = i % str.count
            s += String(str[str.index(str.startIndex, offsetBy: index)])
        }
        if s.contains(t){
            arr.append(Music(i, strs[2], time))
        }
    }
    if arr.count == 0{
        return "(None)"
    }else if arr.count == 1{
        return arr[0].name
    }else{
       arr = arr.sorted(by: {
           if $0.time == $1.time{
               return $0.id < $1.id
           }
            return $0.time > $1.time
        })
        return arr[0].name
    }
    
    return ""
}
func setString(_ s: String) -> String{
    var str = s
    str = str.replacingOccurrences(of: "C#", with: "H")
    str = str.replacingOccurrences(of: "D#", with: "J")
    str = str.replacingOccurrences(of: "F#", with: "K")
    str = str.replacingOccurrences(of: "G#", with: "L")
    str = str.replacingOccurrences(of: "A#", with: "M")
    return str
}
class Music{
    let id: Int
    let name: String
    let time: Int
    init(_ id: Int, _ name: String, _ time: Int){
        self.id = id
        self.name = name
        self.time = time
    }
}
