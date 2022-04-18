//
//  Programmers_NewsClustering.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/18.
//

import Foundation

func solution_NewsClustering(_ str1:String, _ str2:String) -> Int {
    var arr1: [String] = []
    var count = 0
    var sum = 0
    for i in 0..<str1.count-1{
        if !str1[str1.index(str1.startIndex, offsetBy:i)].isLetter{
            continue
        }
        if !str1[str1.index(str1.startIndex, offsetBy:i+1)].isLetter{
            continue
        }
        var word = String(str1[str1.index(str1.startIndex, offsetBy:i)...str1.index(str1.startIndex, offsetBy:i+1)]).lowercased()
        arr1.append(word)
    }
    
    sum += arr1.count
    l: for i in 0..<str2.count-1{
        if !str2[str2.index(str2.startIndex, offsetBy:i)].isLetter{
            continue
        }
        if !str2[str2.index(str2.startIndex, offsetBy:i+1)].isLetter{
            continue
        }
        var word = String(str2[str2.index(str2.startIndex, offsetBy:i)...str2.index(str2.startIndex, offsetBy:i+1)]).lowercased()
        sum += 1
        for j in 0..<arr1.count{
            if arr1[j] == word{
                count += 1
                arr1.remove(at: j)
                continue l
            }
        }
    }
    sum -= count
   
    if count == 0 && sum <= 0 {
        return 65536
    }
    let answer = Double(count) / Double(sum) * 65536.0
    return Int(answer)
}
