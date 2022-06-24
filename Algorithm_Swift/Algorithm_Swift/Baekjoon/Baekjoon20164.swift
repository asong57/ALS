//
//  Baekjoon20164.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/06/24.
//

import Foundation

func BJ20164(){
    var N = Int(readLine()!)!
    var minAnswer = Int.max
    var maxAnswer = 0
    divide(0, N)
    print("\(minAnswer) \(maxAnswer)")

    func countOdd(_ num: Int) -> Int{
        var n = 0
        var temp = num
        while temp > 0{
            if temp % 2 != 0{
                n += 1
            }
            temp /= 10
        }
        return n
    }

    func divide(_ count: Int, _ num: Int){
        var count = count
        var num = num
        if num < 10{
            count += countOdd(num)
            minAnswer = Swift.min(minAnswer, count)
            maxAnswer = Swift.max(maxAnswer, count)
            return
        }
        if num < 100{
            count += countOdd(num)
            num = num % 10 + num / 10
            divide(count, num)
        }else{
            count += countOdd(num)
            let s = String(num)
            for i in 1..<s.count{
                for j in i+1..<s.count{
                    let a = s[s.index(s.startIndex, offsetBy: 0)..<s.index(s.startIndex, offsetBy: i)]
                    let b = s[s.index(s.startIndex, offsetBy: i)..<s.index(s.startIndex, offsetBy: j)]
                    let c = s[s.index(s.startIndex, offsetBy: j)..<s.index(s.startIndex, offsetBy: s.count)]
                    let next = Int(a)! + Int(b)! + Int(c)!
                    divide(count, next)
                }
            }
        }
    }

}
