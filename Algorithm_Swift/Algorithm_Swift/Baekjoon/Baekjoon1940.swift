//
//  Baekjoon1940.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/26.
//

import Foundation
func BJ1940(){
    let n = Int(readLine()!)!
    let t = Int(readLine()!)!
    let array = readLine()!.split(separator: " ").map{ Int($0)!}
    var set: Set<Int> = Set<Int>()
    var count = 0
    for a in array{
        if set.contains(a){
            count += 1
        }else{
            set.insert(t-a)
        }
    }
    print(count)

}
