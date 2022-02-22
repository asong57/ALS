//
//  Programmers_Keypad.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/02/22.
//

import Foundation

func solution(_ numbers:[Int], _ hand:String) -> String {
    var left = 10
    var right = 12
    var answer: String = ""
    for i in 0..<numbers.count{
        print("number: \(numbers[i]) left : \(left) right: \(right)")
        switch numbers[i] {
            case 1,4,7 : answer += "L"
                left = numbers[i]
            case 3,6,9 : answer += "R"
                right = numbers[i]
            default:
                let leftDiff = abs(rowDiff(num: left) - rowDiff(num: numbers[i])) + abs(colDiff(num: left) - colDiff(num: numbers[i]))
                let rightDiff = abs(rowDiff(num: right) - rowDiff(num: numbers[i])) + abs(colDiff(num: right) - colDiff(num: numbers[i]))
                if leftDiff < rightDiff {
                    answer += "L"
                    left = numbers[i]
                }else if leftDiff == rightDiff {
                    let str = hand == "left" ? "L" : "R"
                    answer += str
                    if str == "L" {
                        left = numbers[i]
                    }else{
                        right = numbers[i]
                    }
                }else{
                    answer += "R"
                    right = numbers[i]
                }
        }
    }
    return answer
}

func rowDiff(num: Int) -> Int{
    if num == 0 {
        return 3
    }
    return (num-1)/3
}

func colDiff(num: Int) -> Int{
    if num == 0 {
        return 1
    }
    return (num-1)%3
}
