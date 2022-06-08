//
//  Programmers_GCD.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/06/08.
//

import Foundation

func solution_gcd(_ n:Int, _ m:Int) -> [Int] {
    let a = gcd(n,m)
    let b = n*m/a
    return [a,b]
}
func gcd(_ a: Int, _ b: Int) -> Int {
    if b == 0 {
        return a
    } else {
        return gcd(b, a%b)
    }
}
