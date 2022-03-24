//
//  Programmers_TargetNumber.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/24.
//

import Foundation

func Programmers_TargetNumber(){
    let arr = ["+","-"]
    var num: [Int] = []
    var t = 0
    var answer = 0
    func solution(_ numbers:[Int], _ target:Int) -> Int {
        num = numbers
        t = target
        let temp = Array(repeating: "0", count: numbers.count)
        makePermutation(0, numbers.count, temp)
        return answer
    }
    func makePermutation(_ count: Int, _ k: Int, _ Temp: [String]){
        var temp = Temp
        if count == k{
            var sum = 0
            for i in 0..<temp.count{
                if temp[i] == "+"{
                    sum += num[i]
                }else{
                    sum -= num[i]
                }
            }
            if sum == t{
                answer += 1
            }
        }else{
            for i in 0..<arr.count{
                temp[count] = arr[i]
                makePermutation(count+1, k, temp)
            }
        }
    }
}
