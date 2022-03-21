//
//  Programmers_StringCompaction.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/21.
//

import Foundation

func solutionStringCompaction(_ s:String) -> Int {
    var m = Int.max
    if s.count == 1{
        return 1
    }
    for i in 1..<(s.count/2+1){
        var k = 0
        var j = i
        var str = ""
        var past = ""
        var count = 1
        var now = ""
        while j <= s.count{
            now = String(s[s.index(s.startIndex, offsetBy: k)..<s.index(s.startIndex, offsetBy: j)])
            if past == now {
                count += 1
            }else{
                if j != 0{
                    if count == 1{
                        str += past
                    }else{
                        str += String(count) + past
                    }
                    count = 1
                }
            }
            past = String(now)
            j += i
            k += i
        }
        if count == 1{
            str += past
        }else{
            str += String(count)+now
        }
        if s.count % i != 0{
            str += s[s.index(s.endIndex, offsetBy: -s.count%i)..<s.index(s.endIndex, offsetBy: 0)]
        }
        if str.count > 0{
            m = min(m, str.count)
        }
    }
    return m
}
