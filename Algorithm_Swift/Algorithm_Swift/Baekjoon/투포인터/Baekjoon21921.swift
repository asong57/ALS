//
//  Baekjoon21921.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/16.
//

import Foundation

func BJ21921(){
    let input = readLine()!.split(separator: " ").map{ Int($0)! }
    let x = input[1]
    let arr = readLine()!.split(separator: " ").map{ Int($0)! }
    var m = 0
    var count = 0
    var sum = 0
    for i in 0..<input[1]{
        sum += arr[i]
        if sum > 0{
            m = sum
            count = 1
        }
    }
    for i in x..<arr.count {
        sum += arr[i]
        sum -= arr[i-x]
        if sum > m{
            m = sum
            count = 1
        }else if sum == m{
            count += 1
        }
    }
    if m == 0{
        print("SAD")
    }else{
        print(m)
        print(count)
    }

}
