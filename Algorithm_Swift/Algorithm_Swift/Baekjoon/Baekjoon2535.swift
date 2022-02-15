//
//  Baekjoon2535.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/02/15.
//

import Foundation

func BJ2535(){
    let n = Int(readLine()!)!
    var dict: [Int: String] = [:]
    var arr: [Int] = []
    for _ in 0..<n {
        let input = readLine()!.split(separator: " ").map{ Int($0)! }
        
        dict[input[2]] = "\(input[0]) \(input[1])"
        arr.append(input[2])
    }
    arr.sort(by: >)
    var i = -1
    var pr = 0
    var countDict : [Int: Int] = [:]

    while true {
        i += 1
        let country = (dict[arr[i]]?.split(separator: " ").map{ Int($0)! }[0])!
        
        if countDict[country] == nil {
            countDict[country] = 1
        }else{
            countDict[country]! += 1
        }
        
        if countDict[country]! >= 3 {
            continue
        }else{
            print(dict[arr[i]]!)
            pr += 1
        }
        if pr == 3{
            break
        }
    }
}
