//
//  Programmers_kPrimeNumber.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/07.
//

import Foundation

func solution(_ n:Int, _ k:Int) -> Int {
    var str = changeN(n, k)
    let arr = str.split(separator: "0").map{ Int($0)! }
    var answer = 0
    for num in arr {
        if checkPrimeNumber(num) {
            answer += 1
        }
    }
    return answer
}
func changeN(_ num: Int, _ k: Int) -> String {
    var n = num
    var str = ""
    while n != 0 {
        str = String(n % k) + str
        n = n/k
    }
    return str
}

func checkPrimeNumber(_ n: Int) -> Bool {
    if n == 1 {
        return false
    }
    if n == 2 {
        return true
    }
    if n % 2 == 0{
        return false
    }
    var i = 3
    let limit = Int(sqrt(Float(n)))
    while i <= limit {
        if n % i == 0 {
            return false
        }
        i += 2
    }
    return true
}
