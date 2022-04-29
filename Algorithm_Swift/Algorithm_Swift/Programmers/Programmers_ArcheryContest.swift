//
//  Programmers_ArcheryContest.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/29.
//

import Foundation

let arr:[Int] = [0,1,2,3,4,5,6,7,8,9,10]
var max = 0
var answer:[[Int]] = []
func solution(_ n:Int, _ info:[Int]) -> [Int] {
    var temp = Array(repeating: 0, count: n)
    makeCombination(n, temp, 0, 0,info)
    
    if answer.count == 0{
        return [-1]
    }else if answer.count == 1{
        return answer[0]
    }else{
        var j = 10
        var index = 0
        while j >= 0{
            var min = 0
            for i in 0..<answer.count{
                if min < answer[i][j]{
                    min = answer[i][j]
                    index = i
                }
            }
            if min != 0{
                return answer[index]
            }
            j -= 1
        }
    }
    return []
}
func makeCombination(_ n:Int, _ temp:[Int], _ current:Int,_ start:Int, _ info: [Int]){
    var temp = temp
    if n == current{
        var lion: [Int] = Array(repeating: 0, count: 11)
        for i in 0..<temp.count{
            lion[temp[i]] += 1
        }
        
        var aSum = 0
        var lSum = 0
        for i in 0..<11{
            if info[i] == 0 && lion[i] == 0 {
                continue
            }
            if info[i] >= lion[i]{
                aSum += 10-i
            }else{
                lSum += 10-i
            }
        }
        
        if aSum < lSum{
            let diff = lSum - aSum
            if max < diff{
                max = diff
                answer = []
                answer.append(lion)
            }else if max == diff{
                answer.append(lion)
            }
        }
    }else{
        var i = start
        while i < arr.count{
            temp[current] = arr[i]
            makeCombination(n, temp, current+1, i, info)
            i += 1
        }
    }
}
