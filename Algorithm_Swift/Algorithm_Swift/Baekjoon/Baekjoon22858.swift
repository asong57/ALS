//
//  Baekjoon22858.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/23.
//

import Foundation

func BJ22858(){
    let input = readLine()!.split(separator: " ").map{ Int($0)! }
    let n = input[0]
    let k = input[1]
    var s = readLine()!.split(separator: " ").map{ Int($0)! }
    let D = readLine()!.split(separator: " ").map{ Int($0)! }
    var a: [Int] = Array(repeating: 0, count: n)
    for i in 0..<D.count{
        a[D[i]-1] = s[i]
    }
    for i in 1..<k{
        if i%2 == 0{
            for i in 0..<D.count{
                a[D[i]-1] = s[i]
            }
        }else{
            for i in 0..<D.count{
                s[D[i]-1] = a[i]
            }
        }
    }
    var str = ""
    if k%2 == 0{
        for a in s{
            str += String(a)+" "
        }
        print(str)
    }else{
        for aa in a{
            str += String(aa)+" "
        }
        print(str)
    }
}
