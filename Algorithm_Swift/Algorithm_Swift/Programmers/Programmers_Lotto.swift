//
//  Programmers_Lotto.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/05.
//

import Foundation

func solution_Lotto(_ lottos:[Int], _ win_nums:[Int]) -> [Int] {
    var zeroCount = 0
    var count = 0
    for num in lottos{
        if win_nums.contains(num){
            count += 1
        }
        if num == 0{
            zeroCount += 1
        }
    }
    var answer: [Int] = []
    if count + zeroCount <= 1{
        answer.append(6)
    }else{
         answer.append(6-count-zeroCount+1)
    }
    var minRank = 0
    if count <= 1{
        minRank = 6
    }else{
        minRank = 6-count+1
    }
    answer.append(minRank)
    
    // 다른 방법
    let winCount = lottos.filter{ win_nums.contains($0)}.count
    let zero = lottos.filter { $0 == 0 }.count
    answer = [Swift.min(7 - winCount, 6), Swift.min(6, 7-zero-winCount)]
    return answer
}
