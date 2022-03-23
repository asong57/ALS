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
