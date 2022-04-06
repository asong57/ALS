//
//  Programmers_CrossStone.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/04/06.
//

import Foundation

func cross(_ stones:[Int], _ k:Int, _ n:Int) -> Bool {
    var stone = 0
    for i in 0..<stones.count {
        if stones[i] - n <= 0 { stone += 1 }
        else { stone = 0 }

        if stone >= k { return false }
    }

    return true
}

func solution_CrossStone(_ stones:[Int], _ k:Int) -> Int {
    var left: Int = 1
    var right: Int = 200000001

    while left <= right {
        let mid = (left + right) / 2
        if cross(stones, k, mid) { left = mid + 1 }
        else { right = mid - 1 }

    }

    return left
}
