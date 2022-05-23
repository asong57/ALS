//
//  Programmers_PrimeNumber.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/05/23.
//

import Foundation
func PrimeNumber(){
    var answer = 0
    var set:Set<Int> = Set<Int>()
    func solution(_ numbers:String) -> Int {
        let num = numbers.map{String($0)}
        
        for i in 1...numbers.count{
            let temp = Array(repeating: "", count: i)
            let visit = Array(repeating: false, count: num.count)
            makePermutation(i,0,num,visit, temp)
        }
        return answer
    }
    func makePermutation(_ r: Int,_ current: Int, _ arr: [String], _ visit: [Bool], _ temp: [String]){
        var temp = temp
        var visit = visit
        
        if r == current{
            var str = ""
            for i in 0..<temp.count{
                str += temp[i]
            }
            let nn = Int(str)!
            if checkPrimeNumber(nn){
                if !set.contains(nn){
                    answer += 1
                    set.insert(nn)
                }
            }
        }else{
            for i in 0..<arr.count{
                if !visit[i]{
                    visit[i] = true
                    temp[current] = arr[i]
                    makePermutation(r, current+1, arr, visit, temp)
                    visit[i] = false
                }
            }
        }
    }
    func checkPrimeNumber(_ n:Int) -> Bool{
        if n <= 1{
            return false
        }
        if n == 2{
            return true
        }
        if n%2 == 0{
            return false
        }
        var i = 3
        while i <= Int(sqrt(Float(n)))+1{
            if n % i == 0{
                return false
            }
            i += 2
        }
        return true
    }

}

