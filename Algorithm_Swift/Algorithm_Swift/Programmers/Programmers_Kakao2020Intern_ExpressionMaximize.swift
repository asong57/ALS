//
//  Programmers_Kakao2020Intern_ExpressionMaximize.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/01.
//

import Foundation

var numbers: [Int64] = []
var ops: [Character] = []
let o = ["+", "-", "*"]
var temp: [Character] = Array(repeating: Character(" "), count: 3)
var visited : [Bool] = Array(repeating: false, count: 3)
var max: Int64 = 0

func expressionMaximize(_ expression:String) -> Int64 {
    var num: String = ""
    for (i, c) in expression.enumerated(){
        if c == "*" || c == "-" || c == "+" {
            ops.append(c)
            numbers.append(Int64(num)!)
            num = ""
            
        }else{
            num += String(c)
        }
    }
    numbers.append(Int64(num)!)
    var temp: [Character] = Array(repeating: Character(" "), count: 3)
    makePermutation(count: 0)
    
    return max
}
func makePermutation(count: Int){
    var pTemp = temp
    if(count == 3){
        var pNumbers = numbers
        var pOps = ops
        var j: Int = 0
        for i in 0..<3 {
            j = 0
            while j < pOps.count {
                if pOps[j] == temp[i] {
                    let sum: Int64 = calculate(a: pNumbers.remove(at: j), b: pNumbers.remove(at: j), c: pOps.remove(at: j))
                    pNumbers.insert(sum, at: j)
                    j -= 1
                }
                j += 1
            }
        }
        
        if max < abs(pNumbers[0]) {
            max = abs(pNumbers[0])
        }
    }else{
        for i in 0..<3{
            if !visited[i]{
                visited[i] = true
                temp[count] = Character(o[i])
                makePermutation(count: count+1)
                visited[i] = false
            }
        }
    }
    
}

func calculate(a: Int64, b: Int64, c: Character) -> Int64{
    switch c{
    case "+": return a+b
    case "-": return a-b
    default: return a*b
    }
}
