//
//  Baekjoon2447.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/06/15.
//

import Foundation

func BJ2447(){
    let N = Int(String(readLine()!))!
    var star = ""
    for i in 0..<N {
        for j in 0..<N {
            printStar(N,i,j)
        }
        star += "\n"
    }
    print("\(star)")
    func printStar(_ n: Int, _ i: Int, _ j: Int) {
        if (i / n) % 3 == 1 && (j / n) % 3 == 1 {
            star += " "
        }else {
            if n / 3 == 0 {
                star += "*"
            }else {
                printStar(n / 3, i, j)
            }
        }
    }
}
