//
//  Baekjoon9324.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/02/10.
//

import Foundation

func BJ9324(){
    let n: Int = Int(readLine()!)!
    var arr: [Int]
    
    start : for _ in 0..<n{
        let str = readLine()!.map{ String($0) }
        arr = Array(repeating: 0, count: 26)
        for i in 0..<str.count {
            let index: Int = Int(UnicodeScalar(str[i])!.value) - 65
            
            if arr[index] == 2 {
                if i+1 < str.count && str[i+1] != str[i] {
                    print("FAKE")
                    continue start
                }else if i+1 == str.count {
                    print("FAKE")
                    continue start
                }
            }
            arr[index] += 1
            if arr[index] == 3 {
                arr[index] = -1
            }
        }
        print("OK")
    }
}
