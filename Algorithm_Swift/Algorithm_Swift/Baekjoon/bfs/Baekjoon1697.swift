//
//  Baekjoon1697.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/23.
//

import Foundation

func BJ1697(){
    let input = readLine()!.split(separator: " ").map{ Int($0)! }
    let k = input[1]
    var i = 0
    var array = [input[0]]
    var s = Array(repeating: 100005, count: 100005 )
    s[input[0]] = 0
    while i < array.count{
        var j = array[i]
        if j == k{
            print(s[j])
            break
        }
        let dist = s[j] + 1
        j += 1
        if j < 100005 && dist < s[j]{
            s[j] = dist
            array.append(j)
        }
        j -= 2
        if 0 <= j && dist < s[j] {
            s[j] = dist
            array.append(j)
        }
        j = (j+1)*2
        if j < 100005 && dist < s[j]{
            s[j] = dist
            array.append(j)
        }
        i += 1
    }
}

func BJ1697plus(){
    let NK = readLine()!.split(separator: " ").map { Int(String($0))! }
    let N = NK[0], K = NK[1]
    var V = Array(repeating: false, count: 100001)
    var Q = [(Int, Int)]()
    var I = 0

    Q.append((N, 0))
    V[N] = true

    while I < Q.count {
        let C = Q[I]

        I += 1
        if C.0 == K {
            print(C.1)
            break
        }
        if C.0 + 1 >= 0 && C.0 + 1 <= 100000 && V[C.0 + 1] == false {
            Q.append((C.0 + 1, C.1 + 1))
            V[C.0 + 1] = true
        }
        if C.0 - 1 >= 0 && C.0 - 1 <= 100000 && V[C.0 - 1] == false {
            Q.append((C.0 - 1, C.1 + 1))
            V[C.0 - 1] = true
        }
        if C.0 * 2 >= 0 && C.0 * 2 <= 100000 && V[C.0 * 2] == false {
            Q.append((C.0 * 2, C.1 + 1))
            V[C.0 * 2] = true
        }
    }
}
