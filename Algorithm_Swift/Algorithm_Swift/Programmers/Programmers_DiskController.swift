//
//  Programmers_DiskController.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/05/24.
//

import Foundation

func solution(_ jobs:[[Int]]) -> Int {
    var job = jobs
    if job.count == 1{
        return job[0][1] - job[0][0]
    }
    job = job.sorted{
        return $0[0] < $1[0]
    }
    var i = 0
    var sum = 0
    var arr: [[Int]] = []
    var count = 0
    while count < jobs.count{
        while job.count > 0 && i >= job[0][0]{
            arr.append(job.removeFirst())
        }
        if arr.count > 1{
            arr = arr.sorted(by: {
            return $0[1] < $1[1]
        })
        }
        
        if arr.count > 0{
            let now = arr.removeFirst()
            i += now[1]
            sum += (i - now[0])
            count += 1
        }else{
            i += 1
        }
    }
    let answer = sum / jobs.count
    return answer
}
