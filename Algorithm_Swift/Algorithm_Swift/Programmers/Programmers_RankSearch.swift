//
//  Programmers_RankSearch.swift
//  Algorithm_Swift
//
//  Created by asong on 2022/03/15.
//

import Foundation

var dict: [String: [Int]] = [:]
func solution(_ info:[String], _ query:[String]) -> [Int] {
    let arr = [0,1,2,3]
    for str in info{
        let temp = str.split(separator: " ").map{ String($0) }
        var str = ""
        for i in 0..<temp.count-1{
            str += temp[i]
        }
               
        if dict[str] == nil {
             var array = [Int(temp.last!)!]
            dict[str] = array
        }else{
            var array = dict[str]!
            array.append(Int(temp.last!)!)
            dict[str] = array
        }
        let temp2 = [6,6,6,6]
        for i in 1..<5{
            makeCombination(arr, temp,temp2, 0, 0, i)
        }
    }
    
    for (key, value) in dict{
        dict[key]!.sort()
    }
    var answer: [Int] = []
    for q in query{
        let str = q.split(separator: " ").filter{ $0 != "and"}.map{ String($0) }
        var score = Int(str.last!)!
        var s = ""
        for i in 0..<str.count-1{
            s += str[i]
        }
       
        if dict[s] != nil {
            var count = binarySearch(dict[s]!, score)
            
            answer.append(count)
        }else{
            answer.append(0)
        }
    }
    
    return answer
}
func makeCombination(_ arr: [Int], _ Temp: [String], _ Temp2:[Int], _ count: Int, _ start: Int, _ k: Int){
    var temp = Temp
    var temp2 = Temp2
    if count == k {
       var str = ""
        for i in temp2{
            if i != 6 {
                temp[i] = "-"
            }
        }
        for i in 0..<temp.count-1{
            str += temp[i]
        }
        if dict[str] == nil {
             var array = [Int(temp.last!)!]
            dict[str] = array
        }else{
            var array = dict[str]!
            array.append(Int(temp.last!)!)
            dict[str] = array
        }
    }else{
        var i = start
        while i < arr.count{
            temp2[count] = arr[i]
            makeCombination(arr, temp, temp2, count+1, i+1, k)
            i += 1
        }
    }
}

    func binarySearch(_ list: [Int], _ score: Int) -> Int{
        var count = 0
        var left = 0
        var right = list.count
        var mid = 0
        while (left < right) {
            mid = (left + right) / 2
            if (list[mid] >= score) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        count = list.count - right;

        return count
    }
