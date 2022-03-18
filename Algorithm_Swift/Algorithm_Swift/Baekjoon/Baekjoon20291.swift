//
//  Baekjoon20291.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/18.
//

import Foundation

func BJ20291(){
    let n = Int(readLine()!)!
    var file: [String: Int] = [:]
    for _ in 0..<n{
        let line = readLine()!.split(separator: ".").map{ String($0)}
        if file[line[1]] == nil {
            file[line[1]] = 1
        }else{
            file[line[1]] = file[line[1]]! + 1
        }
    }
    let sortedFile = file.sorted{ $0.0 < $1.0 }
    for (f, _) in sortedFile{
        let a = String(file[f]!)
        print("\(f) \(a)")
    }
}
