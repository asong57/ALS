//
//  Programmers_BracketChange.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/21.
//

import Foundation

func solutionBracketChange(_ p:String) -> String {
    return makeString(p)
}

func makeString(_ p: String) -> String{
    if p == "" {
        return p
    }
    var answer = ""
    var u = String(p[p.index(p.startIndex, offsetBy: 0)..<p.index(p.startIndex, offsetBy: divide(p))])
    var v = String(p[p.index(p.startIndex, offsetBy: divide(p))..<p.index(p.startIndex, offsetBy: p.count)])
              
    if isCorrect(u) {
        answer = u + makeString(v)
    }else{
        answer = "(" + makeString(v) + ")"
        answer += change(u)
    }
              
    return answer
}
func divide(_ p: String) -> Int {
    var a = 0
    var b = 0
    for i in 0..<p.count{
        let c = p[p.index(p.startIndex, offsetBy: i)]
        if c == "("{
            a += 1
        }else{
            b += 1
        }
        if a == b {
            return i+1
        }
    }
    return -1
}
              
              
    func isCorrect(_ p: String) -> Bool{
        var a = 0
        for c in p{
            if c == "("{
                a += 1
            }else{
                a -= 1
            }
            if a < 0{
                return false
            }
        }
        return true
    }
    func change(_ p: String) -> String{
        var str = ""
        for i in 1..<p.count-1{
            let c = p[p.index(p.startIndex, offsetBy: i)]
            if c == ")"{
                str += "("
            }else{
                str += ")"
            }
        }
        return str
    }
