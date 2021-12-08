//
//  Baekjoon1475.swift
//  Algorithm_Swift
//
//  Created by asong on 2021/12/08.
//

import Foundation

func BJ1475(){
    let line = readLine()!
    var n = Int(line)!
    var arr: [Int] = [Int](repeating: 0, count: 10)
    while n > 0 {
        var num = n % 10
        n = n / 10
        if num == 6 || num == 9 {
            if arr[6] > arr[9] {
                arr[9] += 1
            }else if arr[6] < arr[9] {
                arr[6] += 1
            }else{
                arr[num] += 1
            }
        }else{
            arr[num] += 1
        }
    }
    var max: Int = arr.max()!
    print(max)
}
