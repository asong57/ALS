//
//  Programmers_LockKey.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/05/01.
//

import Foundation

func solution_LockKey(_ key:[[Int]], _ lock:[[Int]]) -> Bool {
    var key = key
    var arr: [[Int]] = Array(repeating: Array(repeating: 0, count: key.count), count: key.count)
    let size = lock.count + 2 * (key.count - 1)
    var keyArr: [[Int]] = Array(repeating: Array(repeating: 0, count: size), count: size)
    var k = 0
    while k < 4{
        if k > 0{
            for j in 0..<key.count{
                for i in 0..<key.count{
                    arr[j][key.count-i-1] = key[i][j]
                }
            }
            key = arr
        }else{
            arr = key
        }
        
        for i in 0...size-key.count{
            for j in 0...size-key.count{
                keyArr = Array(repeating: Array(repeating: 0, count: size), count: size)
                for a in 0..<arr.count{
                    for b in 0..<arr.count{
                        keyArr[i+a][j+b] = arr[a][b]
                    }
                }
                if checkKeyAvailable(lock, keyArr, key.count-1){
                    return true
                }
            }
        }
        k += 1
    }
    return false
}
func checkKeyAvailable(_ lock: [[Int]], _ key: [[Int]], _ size:Int) -> Bool{
    for i in 0..<lock.count{
        for j in 0..<lock.count{
            if lock[i][j] == 1 && key[size + i][size + j] == 1{
                return false
            }
            if lock[i][j] == 0 && key[size + i][size + j] == 0{
                return false
            }
        }
    }
    return true
}
