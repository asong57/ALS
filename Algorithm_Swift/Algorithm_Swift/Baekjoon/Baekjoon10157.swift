//
//  Baekjoon10157.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/02/08.
//

import Foundation

func BJ10157(){
    let size = readLine()!.split(separator: " ").map{ Int($0)! }
    let N = size[0]
    let M = size[1]

    var arr: [[Int]] = Array(repeating: Array(repeating: 0, count: size[1]), count: size[0])

    let num = Int(readLine()!)!

    if num > size[0] * size[1] {
        print(0)
    }else{
        
        var i: Int = 0
        var j: Int = -1
        var count = 0
        var check: Bool = false
        
        repeats : while(num != count){
            check = false
            j += 1
            while(j < M && arr[i][j] == 0){
               count += 1
                arr[i][j] = count
                if count == num {
                    print("\(i+1) \(j+1)")
                    break repeats
                }
                j += 1
                check = true
            }
            if check {
                j -= 1
            }
        
            check = false
            i += 1
            while(i < N && arr[i][j]  == 0) {
                count += 1
                arr[i][j] = count
                 if count == num {
                     print("\(i+1) \(j+1)")
                     break repeats
                 }
                i += 1
                check = true
            }
            if check {
                i -= 1
            }
           
            check = false
            j -= 1
            while(j >= 0 && arr[i][j] == 0) {
                count += 1
                arr[i][j] = count
                 if count == num {
                     print("\(i+1) \(j+1)")
                     break repeats
                 }
                j -= 1
                check = true
            }
            if check {
                j += 1
            }
            
            check = false
            i -= 1
            while(i >= 0 && arr[i][j] == 0){
                count += 1
                arr[i][j] = count
                 if count == num {
                     print("\(i+1) \(j+1)")
                     break repeats
                 }
                i -= 1
                check = true
            }
            if check {
                i += 1
            }
        }
    }


}
