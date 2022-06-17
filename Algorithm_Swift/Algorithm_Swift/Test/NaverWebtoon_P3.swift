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
print(solution_NWTP3([1,2,3,4], 20))
