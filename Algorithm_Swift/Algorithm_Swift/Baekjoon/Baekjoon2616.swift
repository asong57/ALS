//
//  Baekjoon2616.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/05/01.
//

import Foundation

func BJ2616_누적합(){
    let n = Int(readLine()!)!
    let customers = readLine()!.split(separator: " ").map{Int($0)!}
    let mc = Int(readLine()!)!
    var sum: [Int] = [customers[0]]
    for i in 1..<n{
        sum.append(sum[i-1] + customers[i])
    }
    var a: [Int] = []
    for i in 0..<n{
        a.append(i)
    }
    var maxCustomer = 0
    makeTrainCombination(0, 0, [0,0,0])
    print(maxCustomer)
    func makeTrainCombination(_ current: Int, _ start: Int, _ temp: [Int]){
        var temp = temp
        if current == 3{
            temp.sort()
            var num = 0
            if temp[1] >= temp[0] + mc && temp[2] >= temp[1] + mc{
                if temp[2] + mc - 1 < n {
                    if temp[0]-1 < 0{
                        num += sum[temp[0]+mc-1]
                    }else{
                        num += sum[temp[0]+mc-1] - sum[temp[0]-1]
                    }
                    num += sum[temp[1]+mc-1] - sum[temp[1]-1]
                    num += sum[temp[2]+mc-1] - sum[temp[2]-1]
                    if num > maxCustomer{
                        maxCustomer = num
                    }
                }
            }
            
        }else{
            var i = start
            while i < a.count{
                temp[current] = a[i]
                makeTrainCombination(current+1, i+mc, temp)
                i += 1
            }
        }
    }

}

func BJ2616_DP(){
    let n = Int(readLine()!)!
    var customers = readLine()!.split(separator: " ").map{Int($0)!}
    customers.insert(0, at: 0)
    let mc = Int(readLine()!)!
    var sum = [0]
    for i in 1...n{
        sum.append(sum[i-1] + customers[i])
    }
    var dp:[[Int]] = Array(repeating: Array(repeating: 0, count: n+1), count: 4)
    for i in 1..<4{
        var j = i*mc
        while j <= n{
            dp[i][j] = Swift.max(dp[i][j-1], dp[i-1][j-mc] + (sum[j] - sum[j-mc]))
            j += 1
        }
    }
    print(dp[3][n])
}
