//
//  Programmers_ParkMoney.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/08.
//

import Foundation

func solution(_ fees:[Int], _ records:[String]) -> [Int] {
    var inSet: Set<String> = Set<String>()
    var time: [String: [Int]] = [:]
    var sum: [String: Int] = [:]
    
    for str in records {
        let input = str.split(separator: " ").map{ String($0) }
        if input[2] == "IN" {
            inSet.insert(input[1])
            let arr: [Int] = input[0].split(separator: ":").map{ Int($0)! }
            time[input[1]] = arr
        }else{
            inSet.remove(input[1])
            let arr: [Int] = input[0].split(separator: ":").map{ Int($0)! }
            let brr = time[input[1]]!
            
            if sum[input[1]] != nil{
                let v: Int = sum[input[1]]!
                if arr[1] >= brr[1] {
                    sum[input[1]] = v + (arr[0] - brr[0]) * 60 + arr[1] - brr[1]
                }else{
                    sum[input[1]] = v + (arr[0] - brr[0] - 1) * 60 + (arr[1] + 60) - brr[1]
                }
            }else{
                  if arr[1] >= brr[1] {
                    sum[input[1]] = (arr[0] - brr[0]) * 60 + arr[1] - brr[1]
                }else{
                    sum[input[1]] = (arr[0] - brr[0] - 1) * 60 + (arr[1] + 60) - brr[1]
                }
            }
          
        }
    }
    
    for value in inSet {
        let brr = time[value]!
        if sum[value] != nil {
            let v: Int = sum[value]!
            sum[value] = v + (23 - brr[0]) * 60 + 59 - brr[1]
        }else{
            sum[value] = (23 - brr[0]) * 60 + 59 - brr[1]
        }
        
    }
    var answer: [Int] = []
    let list = sum.sorted{ $0.0 < $1.0}
    
    for (key, value) in list {
        if value <= fees[0] {
            answer.append(fees[1])
        }else{
            var money = 0
            print(value)
            if (value - fees[0]) % fees[2] != 0 {
                money = fees[1] + ((value - fees[0]) / fees[2] + 1) * fees[3]
            }else{
                money = fees[1] + ((value - fees[0]) / fees[2]) * fees[3]
            }
            answer.append(money)
        }
    }
    
    return answer
}
