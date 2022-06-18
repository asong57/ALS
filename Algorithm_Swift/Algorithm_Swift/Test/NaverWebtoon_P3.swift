//
//  NaverWebtoon_P3.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/06/17.
//

import Foundation

func solution_NWTP3(_ play_list:[Int], _ listen_time: Int) -> Int{
    var answer = 1
    // 슬라이딩 윈도우라고 해야하나?
    // play_list 값마다 최대 몇곡 들을 수 있는지 계산하는 식으로 풀이
    // 값이 큰 원소들에 있어서 시간 초과가 되지 않을지는 잘 모르겠다,,
l: for i in 0..<play_list.count{
        var count = 1
        var j = i+1
        var sum = 0
        while j != i{
            if j >= play_list.count{
                j = 0
            }
            if j == i{
                answer = Swift.max(answer, count)
                continue l
            }
            
            if sum > listen_time-1{
                continue l
            }
            sum += play_list[j]
            count += 1
            j += 1
            answer = Swift.max(answer, count)
        }
    }
    return answer
}
// print(solution_NWTP3_2([2,3,1,4], 3))
func solution_NWTP3_2(_ play_list:[Int], _ listen_time: Int) -> Int{
    var answer = 1
    var playSum: [Int] = Array(repeating: 0, count: play_list.count+1+play_list.count)
    for i in 1...play_list.count{
        playSum[i] = playSum[i-1] + play_list[i-1]
    }
    for i in play_list.count+1..<playSum.count{
        playSum[i] = playSum[i-1] + play_list[i-play_list.count-1]
    }
    
    var left = 0
    var right = 1
    while left < play_list.count{
        if playSum[right] - playSum[left] <= listen_time-1{
            right += 1
            if right == playSum.count{
                break
            }
            if right - left + 1 > play_list.count{
                answer = play_list.count
                return answer
            }
            answer = Swift.max(answer, right - left + 1)
        }else{
            left += 1
        }
    }
    
    return answer
}
